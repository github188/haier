package com.haier.service.impl;

import com.haier.common.token.Token;
import com.haier.dao.UserDao;
import com.haier.domain.User;
import com.haier.service.UserService;
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
            String userKey = Token.getToken(user.getUserName(),"1",user.getMac());
            existuser.setMac(user.getMac());
            existuser.setUser_key(userKey);
            userDao.updateUserUserKeyAndMac(existuser);
            return existuser;
        }
        return null;
    }
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void clearUserKey(User user) throws Exception{
        userDao.deleteUserKey(user);
    }

    @Override
    public Boolean IsValidAccess(String userKey, String u, String t, String m) {

        return userDao.IsValidAccess( userKey,   u,   t,   m);
    }
}
