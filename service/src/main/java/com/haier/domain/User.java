package com.haier.domain;

import com.google.common.base.Strings;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by bright on 16-6-10.
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String name;
    private String sex;
    private String birthday;
    private String address;
    private InputStream headPic;
    private String loginStatus;
    private Date updatetime = new Date();
    private String accessToken;
    private String phone;
    private String source;
    private String source_id;
    private String mac;
    private String user_key;

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public InputStream getHeadPic() {
        return headPic;
    }

    public void setHeadPic(InputStream headPic) {
        this.headPic = headPic;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public boolean check(){
        return Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password) || Strings.isNullOrEmpty(phone) || Strings.isNullOrEmpty(mac);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", headPic=" + headPic +
                ", loginStatus='" + loginStatus + '\'' +
                ", updatetime=" + updatetime +
                ", accessToken='" + accessToken + '\'' +
                ", phone='" + phone + '\'' +
                ", source='" + source + '\'' +
                ", source_id='" + source_id + '\'' +
                '}';
    }
}
