package com.haier.dao.impl;

import com.haier.dao.OrderDao;
import com.haier.domain.ServiceOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by bright on 16-6-5.
 */
@Transactional
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao{

    @Override
    public void save(final ServiceOrder order) {
        final StringBuilder sql = new StringBuilder("insert into t_service_order(" +
                "apply_id,order_code,");
        sql.append("product_id,user_id,he_type,require_time,order_time,arrive_time,work_man_id,");
        sql.append("contact_name,mobile_phone,district,service_address,require_desc,service_time)");
        sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {

                PreparedStatement ps = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, order.getApply_id());
                ps.setString(2, order.getOrder_code());
                ps.setString(3, order.getProduct_id());
                ps.setString(4, order.getUser_id());
                ps.setString(5, order.getService_type());
                ps.setTimestamp(6, new Timestamp(order.getRequire_time().getTime()));
                ps.setTimestamp(7, new Timestamp(order.getOrder_time().getTime()));
                ps.setString(8, order.getArrive_time());
                ps.setString(9, order.getService_man_id());
                ps.setString(10, order.getCotact_name());
                ps.setString(11, order.getMobile_phone());
                ps.setString(12, order.getDistrict());
                ps.setString(13, order.getService_address());
                ps.setString(14, order.getRequire_service_desc());
                ps.setString(15, order.getService_time());
                return ps;
            }
        }, keyHolder);

    }
}
