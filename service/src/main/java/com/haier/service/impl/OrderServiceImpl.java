package com.haier.service.impl;

import com.haier.common.ObjectUtils;
import com.haier.common.exception.ApiException;
import com.haier.dao.OrderDao;
import com.haier.domain.ServiceOrder;
import com.haier.domain.hp.HPAddWoDataResponse;
import com.haier.service.OrderService;
import com.haier.service.hp.HPFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bright on 16-6-5.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private HPFacade hpFacade;
    @Autowired
    private OrderDao orderDao;
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void saveOrder(ServiceOrder serviceOrder) throws Exception {
        HPAddWoDataResponse json=hpFacade.executeAddWoData(ObjectUtils.toMap(serviceOrder));
        serviceOrder.setOrder_code(json.getData());
        orderDao.save(serviceOrder);
    }
}
