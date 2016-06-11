package com.haier.dao.impl;

import com.haier.common.token.Token;
import com.haier.dao.UserDao;
import com.haier.domain.User;
import com.haier.test.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
}
