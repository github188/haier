package com.haier.service.impl;

import com.haier.common.response.Page;
import com.haier.common.response.ServiceOrderPage;
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
        serviceOrder.setIfEvaluate("0");
        logger.debug(serviceOrder.toString());
        orderDao.save(serviceOrder);
    }
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public ServiceOrderPage getOrderListPage(ServiceOrderPage page) throws Exception {
        List<ServiceOrder> orderList = orderDao.findServiceOrdersByUserId(page.getUser_id());
        User user = new User();
        user.setId(page.getUser_id());
        for(ServiceOrder order:orderList){
            //更新用户的所有订单
            HPWoWholeInfoResponse json = hpFacade.executeWoWholeInfo(order.getOrder_code());
            if(!json.getCode().equals("200")){
                logger.error(json.getMsg()+" hp 获取工单失败");
                //throw new Exception(json.getMsg()+" hp 获取工单失败");
                HPWoWholeInfo info = new HPWoWholeInfo();
                info.setWo_status("3");
                info.setWo_status_name("已结单");
                json.setData(info);
            }
            orderDao.updateOrderServiceStatus(user,json.getData());
        }
        page = orderDao.getOrderListPage(page);

        return page;
    }
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public List<ServiceOrderTrace> getServiceOrderTrack(String orderCode) throws Exception{
        //从HP接口获得最新的订单信息
        HPWoWholeInfoResponse json = hpFacade.executeWoWholeInfo(orderCode);
        //更新本地的订单轨迹,饼返回
        if(!"200".equals(json.getCode())){
            logger.error(json.getMsg()+" hp 获取工单失败");
            //throw new Exception("从HP接口获取订单详情失败");
        }
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
