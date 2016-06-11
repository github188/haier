package com.haier.dao;

import com.haier.domain.ServiceOrder;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
public interface OrderDao {
    public void save(final ServiceOrder order);
    public void updateOrderServiceStatus(User user, List<HPWoListData> hpwoList);
}
