package com.haier.dao;

import com.haier.common.response.Page;
import com.haier.common.response.ServiceOrderPage;
import com.haier.domain.ServiceOrder;
import com.haier.domain.ServiceOrderTrace;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;
import com.haier.hp.domain.HPWoWholeInfo;
import com.haier.hp.domain.HPWoWholeInfoResponse;
import com.haier.service.OrderService;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
public interface OrderDao {
    public void save(final ServiceOrder order);
    public void updateOrderServiceStatus(User user, HPWoWholeInfo info);

    public ServiceOrderPage getOrderListPage(ServiceOrderPage page) throws Exception;

    public List<ServiceOrderTrace> updateOrderServiceTrack(String orderCode, HPWoWholeInfoResponse json) throws Exception;

    public List<ServiceOrder>findServiceOrdersByUserId(int userId) throws Exception;
}
