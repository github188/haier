package com.haier.service;

import com.haier.domain.ServiceOrder;

/**
 * Created by bright on 16-6-5.
 */
public interface OrderService {

    public void saveOrder(ServiceOrder serviceOrder) throws Exception;
}
