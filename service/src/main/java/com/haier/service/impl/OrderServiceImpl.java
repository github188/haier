package com.haier.service.impl;

import com.haier.common.response.Page;
import com.haier.dao.OrderDao;
import com.haier.dao.UserDao;
import com.haier.domain.ServiceOrder;
import com.haier.domain.ServiceOrderTrace;
import com.haier.domain.User;
import com.haier.hp.domain.*;
import com.haier.hp.service.HPFacade;
import com.haier.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private HPFacade hpFacade;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void saveOrder(ServiceOrder serviceOrder) throws Exception {

        HPAddWoDataRequest request = build(serviceOrder);
        HPAddWoDataResponse json=hpFacade.executeAddWoData(request);
        if(!json.getCode().equals("200")){
            throw new  Exception(json.getMsg()+" hp 对接失败");
        }
        serviceOrder.setOrder_code(json.getData());
        logger.debug(serviceOrder.toString());
        orderDao.save(serviceOrder);
    }
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public Page getOrderListPage(ServiceOrder order,Page page) throws Exception {
        User user = userDao.findUserById(order.getUser_id());
        HPWoListResponse json = hpFacade.executeWoList(user.getPhone());
        if(!json.getCode().equals("200")){
            throw new Exception(json.getMsg()+" hp 获取工单失败");
        }
        orderDao.updateOrderServiceStatus(user,json.getData());

        page = orderDao.getOrderListPage(order,page);

        return page;
    }
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public List<ServiceOrderTrace> getServiceOrderTrack(String orderCode) throws Exception{
        //从HP接口获得最新的订单信息
        HPWoWholeInfoResponse json = hpFacade.executeWoWholeInfo(orderCode);
        //更新本地的订单轨迹,饼返回
        List<ServiceOrderTrace> list = orderDao.updateOrderServiceTrack(orderCode,json);
        return list;
    }

    static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private HPAddWoDataRequest build(ServiceOrder serviceOrder){
        return HPAddWoDataRequestBuilder.create()
                .setApply_id(serviceOrder.getApply_id()).setProduct_id(serviceOrder.getProduct_id())
                .setService_type(serviceOrder.getService_type()).setRequire_service_date(sdf.format(serviceOrder.getRequire_service_date()))
                .setCustomer_name(serviceOrder.getContact_name()).setMobile_phone(serviceOrder.getMobile_phone())
                .setDistrict(serviceOrder.getDistrict()).setAddress(serviceOrder.getAddress()).setRequire_service_desc(serviceOrder.getRequire_service_desc())
                .setService_time(serviceOrder.getService_time()).build();
    }
}
