package com.haier.service.impl;

import com.haier.common.token.Token;
import com.haier.dao.UserDao;
import com.haier.domain.User;
import com.haier.domain.UserAddress;
import com.haier.domain.UserProduct;
import com.haier.service.UserService;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bright on 16-6-10.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public User addNewUser(User user) throws Exception{
        User existuser = userDao.findUserByUserName(user);
        if(existuser != null){
            throw new  Exception("用户名已存在，请使用其他用户名");
        }
        return userDao.add(user);
    }

    @Override
    public User isExistsUser(User user) throws Exception{
        User existuser = userDao.findUser(user);
        if(existuser != null){
            //如果登录成功则更新用户AccessToken
            String accessToken = Token.getToken(user.getUserName(),"1",user.getMac());
            existuser.setMac(user.getMac());
            existuser.setAccessToken(accessToken);
            userDao.updateUserAccessTokenAndMac(existuser);
            return existuser;
        }
        return null;
    }
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void clearAccessToken(User user) throws Exception{
        userDao.deleteAccessToken(user);
    }

    @Override
    public Boolean IsValidAccess(String userKey, int u, String t, String m) {

        return userDao.IsValidAccess( userKey,   u,   t,   m);
    }

    @Override
    public void addUserProduct(UserProduct userProduct) {

    }

    @Override
    public List<UserProduct> listUserProduct(User user) {
        return null;
    }

    @Override
    public void addUserAddress(UserAddress userAddress) {

    }

    @Override
    public List<UserAddress> listUserAddress(User user) {
        return null;
    }
}
