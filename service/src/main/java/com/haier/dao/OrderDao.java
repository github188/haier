package com.haier.dao;

import com.haier.domain.ServiceOrder;

/**
 * Created by bright on 16-6-5.
 */
public interface OrderDao {
    public void save(final ServiceOrder order);
}
