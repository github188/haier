package com.haier.service.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.haier.common.token.Token;
import com.haier.dao.UserDao;
import com.haier.domain.User;
import com.haier.domain.UserAddress;
import com.haier.domain.UserProduct;
import com.haier.service.UserService;
import com.haier.weixin.domain.WeiXinResponse;
import com.haier.weixin.service.WeiXinFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bright on 16-6-10.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private WeiXinFacade weiXinFacade;
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
    @Override
    public Boolean isExistsUserName(String userName) throws Exception{
        Boolean flag = false;
        User user = new User();
        user.setUserName(userName);
        user = userDao.findUserByUserName(user);
        if(user != null){
            flag = true;
        }
        return flag;
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

    @Override
    public String isExistWithOpenId(String openId) throws Exception {
        return userDao.isExistWithOpenId(openId);

    }

    @Override
    public void sendQrcode(String openId, String user) throws Exception {

//        weiXinFacade.userRegister()
    }

    /**
     * 您已成功注册海尔会员，登录账号15022086097默认密码vkbwdj；登录vip.haier.com互动赢好礼，免费获得家电保养,更多精彩尽在海尔
     * @param openId
     * @param phone
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public String wxRegister(String openId, String phone,String code) throws Exception {
        try {
            WeiXinResponse response = weiXinFacade.userActivate(code, openId);
            if(response.getIsAskNextRequest().equals("false")){
                //注册
                String str=response.getBody().getContent().replace("您已成功注册海尔会员，登录账号","").replace("默认密码",";").replace("；登录vip.haier.com互动赢好礼，免费获得家电保养,更多精彩尽在海尔",";");
                List<String> up= Lists.newArrayList(Splitter.on(";").trimResults().split(str));
                if(up.size()==3){
                    return userDao.wxRegister(openId,phone,code,up.get(0),up.get(1));
                }else{
                    return userDao.wxRegister(openId,phone,code,phone,"");
                }

            }
            return "";
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("微信激活注册失败");
        }
    }
}
