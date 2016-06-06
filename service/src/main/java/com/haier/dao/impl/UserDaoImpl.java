package com.haier.dao.impl;

import com.haier.dao.UserDao;
import com.haier.test.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created b
 * y ehl on 2016/6/4.
 */
@Transactional(readOnly = true)
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
}
