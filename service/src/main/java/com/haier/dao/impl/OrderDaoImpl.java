package com.haier.dao.impl;

import com.haier.common.response.Page;
import com.haier.dao.OrderDao;
import com.haier.domain.ServiceOrder;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;
import com.haier.service.OrderService;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;
import java.util.Map;

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
                ps.setTimestamp(6, new Timestamp(order.getRequire_service_date().getTime()));
                ps.setTimestamp(7, new Timestamp(order.getOrder_time().getTime()));
                ps.setString(8, order.getArrive_time());
                ps.setString(9, order.getService_man_id());
                ps.setString(10, order.getContact_name());
                ps.setString(11, order.getMobile_phone());
                ps.setString(12, order.getDistrict());
                ps.setString(13, order.getAddress());
                ps.setString(14, order.getRequire_service_desc());
                ps.setString(15, order.getService_time());
                return ps;
            }
        }, keyHolder);
    }

    @Override
    public void updateOrderServiceStatus(User user, final List<HPWoListData> hpwoList) {

        StringBuilder sql = new StringBuilder("update t_service_order set status = ?,status_desc = ? where mobile_phone='");
        sql.append(user.getPhone());
        sql.append("' and order_code = ?");
        super.getJdbcTemplate().batchUpdate(sql.toString(), new BatchPreparedStatementSetter(){

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                HPWoListData data = hpwoList.get(i);
                preparedStatement.setString(1,data.getWo_status());
                preparedStatement.setString(2,data.getWo_status_zy());
                preparedStatement.setString(3,data.getWo_id());
            }

            @Override
            public int getBatchSize() {
                return hpwoList.size();
            }
        });
    }

    @Override
    public Page getOrderListPage(User user, Page page) throws Exception {

        StringBuilder countsql = new StringBuilder("select count(1) recordnum from t_order_service where user_id = ");
        countsql.append(user.getId());
        countsql.append("limit  ");
        countsql.append((page.getPageNumber()-1)*page.getPageSize());
        countsql.append(",");
        countsql.append(page.getPageSize());

        Map<String, Object> result = super.getJdbcTemplate().queryForMap(countsql.toString());

        Long count = Long.parseLong((String)result.get("recordnum"));

        StringBuilder sql = new StringBuilder("select * from t_order_service where user_id = ");
        sql.append(user.getId());
        sql.append("limit  ");
        sql.append((page.getPageNumber()-1)*page.getPageSize());
        sql.append(",");
        sql.append(page.getPageSize());


        List<ServiceOrder> list = super.getBySqlRowMapper(sql.toString(), new RowMapper<ServiceOrder>() {
            @Override
            public ServiceOrder mapRow(ResultSet resultSet, int i) throws SQLException {
                ServiceOrder serviceOrder = new ServiceOrder();
                serviceOrder.setId(resultSet.getInt("id"));
                serviceOrder.setApply_id(resultSet.getString("apply_id"));
                serviceOrder.setAddress(resultSet.getString("service_address"));
                serviceOrder.setArrive_time(resultSet.getString("arrive_time"));
                serviceOrder.setContact_name(resultSet.getString("contact_name"));
                serviceOrder.setDistrict(resultSet.getString("district"));
                serviceOrder.setMobile_phone(resultSet.getString("mobile_phone"));
                serviceOrder.setOrder_code(resultSet.getString("order_code"));
                serviceOrder.setOrder_time(resultSet.getDate("order_time"));
                serviceOrder.setProduct_id(resultSet.getString("product_id"));
                serviceOrder.setRequire_service_date(resultSet.getDate("require_time"));
                serviceOrder.setRequire_service_desc(resultSet.getString("require_desc"));
                serviceOrder.setService_man_id(resultSet.getString("work_man_id"));
                serviceOrder.setService_time(resultSet.getString("service_time"));
                serviceOrder.setService_type(resultSet.getString("he_type"));
                serviceOrder.setUser_id(resultSet.getString("user_id"));
                serviceOrder.setUpdatetime(resultSet.getDate("updatetime"));
                serviceOrder.setStatus(resultSet.getString("status"));
                serviceOrder.setStatusDesc(resultSet.getString("status_desc"));
                return serviceOrder;
            }
        });
        page.setMessages(list);
        page.setCount(count);
        return page;
    }
}
