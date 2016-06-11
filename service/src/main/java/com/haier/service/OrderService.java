package com.haier.service;

import com.haier.common.response.Page;
import com.haier.domain.ServiceOrder;
import com.haier.domain.ServiceOrderTrace;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
public interface OrderService {

    public void saveOrder(ServiceOrder serviceOrder) throws Exception;

    public Page getOrderListPage(User user,Page page) throws Exception;

    public List<ServiceOrderTrace> getServiceOrderTrack(String orderCode)  throws Exception;
}
