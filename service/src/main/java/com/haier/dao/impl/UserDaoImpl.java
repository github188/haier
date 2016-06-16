package com.haier.dao.impl;

import com.haier.common.token.Token;
import com.haier.dao.UserDao;
import com.haier.domain.User;
import com.haier.domain.UserAddress;
import com.haier.domain.UserProduct;
import com.haier.test.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created b
 * y ehl on 2016/6/4.
 */
@Transactional
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public List<Test> test() {
        try {
            List<Test> list =  super.getBySqlRowMapper("select * from sys_user_role", new RowMapper<Test>() {
                @Override
                public Test mapRow(ResultSet resultSet, int i) throws SQLException {
                    Test t = new Test();
                    t.setRole_id(resultSet.getString("role_id"));
                    t.setUser_id(resultSet.getString("user_id"));
                    return t;
                }
            });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HashMap<String, String>> findCity() {
        try {
            List<HashMap<String,String>> list =  super.getBySqlRowMapper("select distinct pro_code,city_code,city from t_region", new RowMapper<HashMap<String,String>>() {
                @Override
                public HashMap<String,String> mapRow(ResultSet resultSet, int i) throws SQLException {
                    HashMap<String,String> map = new HashMap<String,String>();
                    int n = 1;
                    while(n<=resultSet.getMetaData().getColumnCount()){
                        map.put(resultSet.getMetaData().getColumnLabel(n),resultSet.getString(resultSet.getMetaData().getColumnLabel(n)));
                        n++;
                    }
                    return map;
                }
            });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HashMap<String, String>> findProvince() {
        try {
            List<HashMap<String,String>> list =  super.getBySqlRowMapper("select distinct pro_code,province from t_region", new RowMapper<HashMap<String,String>>() {
                @Override
                public HashMap<String,String> mapRow(ResultSet resultSet, int i) throws SQLException {
                    HashMap<String,String> map = new HashMap<String,String>();
                    int n = 1;
                    while(n<=resultSet.getMetaData().getColumnCount()){
                        map.put(resultSet.getMetaData().getColumnLabel(n),resultSet.getString(resultSet.getMetaData().getColumnLabel(n)));
                        n++;
                    }
                    return map;
                }
            });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HashMap<String, String>> findRegion() {
        try {
            List<HashMap<String,String>> list =  super.getBySqlRowMapper("select distinct city_code,admin_code,region_name from t_region", new RowMapper<HashMap<String,String>>() {
                @Override
                public HashMap<String,String> mapRow(ResultSet resultSet, int i) throws SQLException {
                    HashMap<String,String> map = new HashMap<String,String>();
                    int n = 1;
                    while(n<=resultSet.getMetaData().getColumnCount()){
                        map.put(resultSet.getMetaData().getColumnLabel(n),resultSet.getString(resultSet.getMetaData().getColumnLabel(n)));
                        n++;
                    }
                    return map;
                }
            });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(readOnly = false)
    @Override
    public User add(final User user) {
        final String accessToken = Token.getToken(user.getUserName(), "1", user.getMac());
        user.setAccessToken(accessToken);
        final StringBuilder sql = new StringBuilder("insert into t_user(" +
                "username,password,");
        sql.append("name,sex,birthday,mobile,address,head_pic,login_status,");
        sql.append("updatetime,user_source,user_source_id,access_token,mac)");
        sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {

                PreparedStatement ps = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getName());
                ps.setString(4, user.getSex());
                ps.setString(5, user.getBirthday());
                ps.setString(6, user.getPhone());
                ps.setString(7, user.getAddress());
                ps.setBinaryStream(8, null);
                ps.setString(9, user.getLoginStatus());
                ps.setTimestamp(10, new Timestamp(user.getUpdatetime().getTime()));
                ps.setString(11, user.getSource());
                ps.setString(12, user.getSource_id());
                ps.setString(13, user.getAccessToken());
                ps.setString(14,user.getMac());
                return ps;
            }
        }, keyHolder);
        user.setId(keyHolder.getKey().intValue());
        return user;
    }
    @Transactional(readOnly = true)
    @Override
    public User findUser(User user) {
        try {
            StringBuilder builder = new StringBuilder("select * from t_user where username ='");
            builder.append(user.getUserName());
            builder.append("' and password = '");
            builder.append(user.getPassword());
            builder.append("'");
            List<User> list =  super.getBySqlRowMapper(builder.toString(), new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    return user;
                }
            });
            if(list.size() > 0){
                return list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserById(int id) {
        StringBuilder sql = new StringBuilder("select * from t_user where id = ");
        sql.append(id);
        return super.getJdbcTemplate().queryForObject(sql.toString(), new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPhone(resultSet.getString("mobile"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        });
    }

    @Override
    public User findUserByUserName(User user) {
        try {
            StringBuilder builder = new StringBuilder("select * from t_user where username ='");
            builder.append(user.getUserName());
            builder.append("'");
            List<User> list =  super.getBySqlRowMapper(builder.toString(), new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    return user;
                }
            });
            if(list.size() > 0){
                return list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteAccessToken(User user) throws Exception{
        StringBuilder builder = new StringBuilder("update t_user set access_token = null,mac = null where id=");
        builder.append(user.getId());
        super.update(builder.toString());
    }

    @Override
    public void updateUserAccessTokenAndMac(User user) throws Exception{
        StringBuilder builder = new StringBuilder("update t_user set access_token = '");
        builder.append(user.getAccessToken());
        builder.append("', mac = '");
        builder.append(user.getMac());
        builder.append("' where id = ");
        builder.append(user.getId());
        super.update(builder.toString());
    }

    @Override
    public Boolean IsValidAccess(String accessToken,int u,String t,String m)
    {
        Boolean ret =false;
        try{
            String sql = "SELECT 1 FROM t_user WHERE id=? and access_token=?";
            String info = null;
            try{
                info =jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<String>(String.class),u,accessToken );
            } catch (Exception e) {
                info = null;
            }
            ret= (info == null ?false:true);
        } catch (Exception e) {
            ret = false;
        }
        return ret;
    }

    @Override
    public void addUserProduct(final UserProduct userProduct) {
        final StringBuilder sql = new StringBuilder("insert into t_user_product(user_id,brand,");
        sql.append("category,sub_category,type,product_code,purchase_date,guarantee_year,service_address");
        sql.append("updatetime)");
        sql.append(" values(?,?,?,?,?,?,?,?,?,?)");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {

                PreparedStatement ps = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userProduct.getUserId());
                ps.setString(2, userProduct.getBrand());
                ps.setString(3, userProduct.getCategory());
                ps.setString(4, userProduct.getSubCategory());
                ps.setString(5, userProduct.getType());
                ps.setString(6, userProduct.getProductCode());
                ps.setTimestamp(7, new Timestamp(userProduct.getPurchaseDate().getTime()));
                ps.setInt(8, userProduct.getGuaranteeYear());
                ps.setString(9, userProduct.getServiceAddress());
                ps.setTimestamp(10, new Timestamp(userProduct.getUpdatetime().getTime()));
                return ps;
            }
        }, keyHolder);
    }

    @Override
    public List<UserProduct> listUserProduct(User user) throws Exception{
        StringBuilder builder = new StringBuilder("select * from t_user_product where user_id =");
        builder.append(user.getId());
        List<UserProduct> list =  super.getBySqlRowMapper(builder.toString(), new RowMapper<UserProduct>() {
            @Override
            public UserProduct mapRow(ResultSet resultSet, int i) throws SQLException {
                UserProduct userProduct = new UserProduct();
                userProduct.setId(resultSet.getInt("id"));
                userProduct.setUserId(resultSet.getInt("user_id"));
                userProduct.setBrand(resultSet.getString("brand"));
                userProduct.setCategory(resultSet.getString("category"));
                return userProduct;
            }
        });
        return list;
    }

    @Override
    public void addUserAddress(UserAddress userAddress) {

    }

    @Override
    public List<UserAddress> listUserAddress(User user) {
        return null;
    }
    @Transactional(readOnly = false)
    @Override
    public String wxRegister(final String openId, final String phone, final String code, final String userName, final String password) throws Exception {
        final StringBuilder sql = new StringBuilder("insert into t_user(" +
                "username,password,");
        sql.append("name,sex,birthday,mobile,address,head_pic,login_status,");
        sql.append("updatetime,user_source,user_source_id,access_token,mac)");
        sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            super.getJdbcTemplate().update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con)
                        throws SQLException {

                    PreparedStatement ps = con.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1, userName);
                    ps.setString(2, password);
                    ps.setString(3, phone);
                    ps.setString(4, "");
                    ps.setString(5, "");
                    ps.setString(6, phone);
                    ps.setString(7, "");
                    ps.setBinaryStream(8, null);
                    ps.setString(9, "1");
                    ps.setTimestamp(10, new Timestamp(new java.util.Date().getTime()));
                    ps.setString(11, "wx");
                    ps.setString(12, openId);
                    ps.setString(13, openId);
                    ps.setString(14, "");
                    return ps;
                }
            }, keyHolder);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return "你的用户名:"+userName+";密码:"+password;
    }

    @Override
    public String isExistWithOpenId(final String openId) throws Exception {
        StringBuilder sql = new StringBuilder("select id from t_user where user_source_id=?");
        List<String>  result = super.getJdbcTemplate().query(sql.toString(), new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,openId);
            }
        }, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(1);
            }
        });
        if(null == result ||result.size()==0){
            return "";
        }
        return result.get(0);
    }
}
