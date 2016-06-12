package com.haier.dao;

import com.haier.common.response.Page;
import com.haier.domain.ServiceOrder;
import com.haier.domain.ServiceOrderTrace;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;
import com.haier.hp.domain.HPWoWholeInfoResponse;
import com.haier.service.OrderService;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
public interface OrderDao {
    public void save(final ServiceOrder order);
    public void updateOrderServiceStatus(User user, List<HPWoListData> hpwoList);

    public Page getOrderListPage(User user, Page page) throws Exception;

    public List<ServiceOrderTrace> updateOrderServiceTrack(String orderCode, HPWoWholeInfoResponse json) throws Exception;
}
