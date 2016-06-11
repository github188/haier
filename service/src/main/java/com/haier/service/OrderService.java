package com.haier.service;

import com.haier.domain.ServiceOrder;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
public interface OrderService {

    public void saveOrder(ServiceOrder serviceOrder) throws Exception;

    public List<HPWoListData> getOrderList(User user) throws Exception;
}
