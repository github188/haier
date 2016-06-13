package com.haier.dao.impl;

import com.google.common.base.Strings;
import com.haier.common.response.Page;
import com.haier.common.response.ServiceOrderPage;
import com.haier.dao.OrderDao;
import com.haier.domain.ServiceOrder;
import com.haier.domain.ServiceOrderTrace;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;
import com.haier.hp.domain.HPWoWholeInfo;
import com.haier.hp.domain.HPWoWholeInfoResponse;
import com.haier.service.OrderService;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        sql.append("contact_name,mobile_phone,district,service_address,require_desc,service_time,if_evaluate)");
        sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {

                PreparedStatement ps = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, order.getApply_id());
                ps.setString(2, order.getOrder_code());
                ps.setString(3, order.getProduct_id());
                ps.setInt(4, order.getUser_id());
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
                ps.setString(16, order.getIfEvaluate());
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
    public ServiceOrderPage getOrderListPage(ServiceOrderPage page) throws Exception {

        StringBuilder countsql = new StringBuilder("select count(1) recordnum from t_service_order where user_id = ");
        countsql.append(page.getUser_id());
        if("1".equals(page.getStatus())){
            countsql.append(" and status = '3'");
        }else{
            countsql.append(" and status in ('0','1','2')");
        }


        Map<String, Object> result = super.getJdbcTemplate().queryForMap(countsql.toString());

        Long count = (Long)result.get("recordnum");

        StringBuilder sql = new StringBuilder("select * from t_service_order where user_id = ");
        sql.append(page.getUser_id());
        if("1".equals(page.getStatus())){
            sql.append(" and status = '3'");
        }else{
            sql.append(" and status in ('0','1','2')");
        }
        sql.append(" order by updatetime asc limit  ");
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
                serviceOrder.setOrder_time(resultSet.getTimestamp("order_time"));
                serviceOrder.setProduct_id(resultSet.getString("product_id"));
                serviceOrder.setRequire_service_date(resultSet.getDate("require_time"));
                serviceOrder.setRequire_service_desc(resultSet.getString("require_desc"));
                serviceOrder.setService_man_id(resultSet.getString("work_man_id"));
                serviceOrder.setService_time(resultSet.getString("service_time"));
                serviceOrder.setService_type(resultSet.getString("he_type"));
                serviceOrder.setUser_id(resultSet.getInt("user_id"));
                serviceOrder.setUpdatetime(resultSet.getTimestamp("updatetime"));
                serviceOrder.setStatus(resultSet.getString("status"));
                serviceOrder.setStatusDesc(resultSet.getString("status_desc"));
                serviceOrder.setIfEvaluate(resultSet.getString("if_evaluate"));
                return serviceOrder;
            }
        });
        page.setMessages(list);
        page.setCount(count);
        return page;
    }

    @Override
    public List<ServiceOrderTrace> updateOrderServiceTrack(final String orderCode, HPWoWholeInfoResponse json) throws Exception{
        HPWoWholeInfo info = json.getData();
        StringBuilder querysql = new StringBuilder("select * from t_service_track where order_code = ? order by status asc");
        if(!Strings.isNullOrEmpty(info.getCall_time())){
            updateOrInsertOrderTrace(orderCode,info,"0");
        }
        if(!Strings.isNullOrEmpty(info.getAssign_date())){
            updateOrInsertOrderTrace(orderCode,info,"1");
        }
        if(!Strings.isNullOrEmpty(info.getEnter_time())){
            updateOrInsertOrderTrace(orderCode,info,"2");
        }
        if(!Strings.isNullOrEmpty(info.getServer_close_time())){
            updateOrInsertOrderTrace(orderCode,info,"3");
        }
        return super.getJdbcTemplate().query(querysql.toString(), new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,orderCode);
            }
        }, new RowMapper<ServiceOrderTrace>() {
            @Override
            public ServiceOrderTrace mapRow(ResultSet resultSet, int i) throws SQLException {
                ServiceOrderTrace trace = new ServiceOrderTrace();
                trace.setId(resultSet.getInt("id"));
                trace.setOrderCode(resultSet.getString("order_code"));
                String status = resultSet.getString("status");
                trace.setStatus(status);
                if("0".equals(status)){
                    trace.setDescription("已提交成功");
                }else if("1".equals(status)){
                    trace.setDescription("已受理");
                }else if("2".equals(status)){
                    trace.setDescription("正在服务");
                }else{
                    trace.setDescription("服务完成");
                }

                trace.setUpdatetime(resultSet.getTimestamp("updatetime"));
                return trace;
            }
        });
    }

    private void updateOrInsertOrderTrace(String orderCode, HPWoWholeInfo info,String type) throws Exception{
        StringBuilder countsql = new StringBuilder("select count(1) recordnum from t_service_track where order_code = ? and status = ? ");
        StringBuilder updatesql = new StringBuilder("update t_service_track set updatetime = ? where order_code = ? and status = ?");
        StringBuilder insertsql = new StringBuilder("insert into t_service_track(order_code,status,updatetime) values(?,?,?)");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Object[] param1 = new Object[2];
        param1[0] = orderCode;
        param1[1] = type;
        Map<String,Object> map = super.getJdbcTemplate().queryForMap(countsql.toString(),param1);
        if((Long)map.get("recordnum") != 0L){
            Object[] param2 = new Object[3];
            if("0".equals(type)){
                param2[0] = format.parse(info.getCall_time());
            }else if("1".equals(type)){
                param2[0] = format.parse(info.getAssign_date());
            }else if("2".equals(type)){
                param2[0] = format.parse(info.getEnter_time());
            }else{
                param2[0] = format.parse(info.getServer_close_time());
            }
            param2[1] = orderCode;
            param2[2] = type;
            super.getJdbcTemplate().update(updatesql.toString(),param2);
        }else{
            Object[] param3 = new Object[3];
            param3[0] = orderCode;
            param3[1] = type;
            if("0".equals(type)){
                param3[2] = format.parse(info.getCall_time());
            }else if("1".equals(type)){
                param3[2] = format.parse(info.getAssign_date());
            }else if("2".equals(type)){
                param3[2] = format.parse(info.getEnter_time());
            }else{
                param3[2] = format.parse(info.getServer_close_time());
            }
            super.getJdbcTemplate().update(insertsql.toString(),param3);
        }
    }
}
