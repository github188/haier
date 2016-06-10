package com.haier.dao;

import com.haier.domain.User;
import com.haier.test.Test;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    public List<Test> test();

    public List<HashMap<String,String>> findCity();

    public List<HashMap<String,String>> findProvince();

    public List<HashMap<String,String>> findRegion();

    public User add(User user);

    public User findUser(User user);

    public User findUserByUserName(User user);

    public void deleteAccessToken(User user) throws Exception;

    public void updateUserAccessTokenAndMac(User user) throws Exception;

    public Boolean IsValidAccess(String accessToken,int u,String t,String m);
}
