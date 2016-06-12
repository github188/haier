package com.haier.service;

import com.haier.domain.User;
import com.haier.domain.UserAddress;
import com.haier.domain.UserProduct;

import java.util.List;

/**
 * Created by bright on 16-6-10.
 */
public interface UserService {
    public User addNewUser(User user) throws Exception;
    public User isExistsUser(User user) throws Exception;
    public Boolean isExistsUserName(String userName) throws Exception;
    public void clearAccessToken(User user) throws Exception;
    public Boolean IsValidAccess(String userKey, int u, String t, String m);
    public void addUserProduct(UserProduct userProduct);
    public List<UserProduct> listUserProduct(User user);
    public void addUserAddress(UserAddress userAddress);
    public List<UserAddress> listUserAddress(User user);

    public String isExistWithOpenId(String openId) throws Exception;

    /**
     * 微信 发送验证码
     * @param openId
     * @param user
     * @throws Exception
     */
    public void sendQrcode(String openId,String user) throws Exception;

    /**
     *微信激活
     * @param openId
     * @param phone
     * @return
     * @throws Exception
     */
    public String wxRegister(String openId,String phone,String code) throws Exception;
}
