package com.haier.service.impl;

import com.haier.dao.OrderDao;
import com.haier.domain.ServiceOrder;
import com.haier.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bright on 16-6-5.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;
    @Override
    public void saveOrder(ServiceOrder serviceOrder) throws Exception {
        orderDao.save(serviceOrder);
    }
}
