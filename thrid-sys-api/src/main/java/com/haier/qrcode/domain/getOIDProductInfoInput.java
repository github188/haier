package com.haier.qrcode.domain;

/**
 * Created by Administrator on 2016/6/9.
 */
public class GetOIDProductInfoInput {
    private String userName;

    private String pwd;

    private String oidContent;

    public String getOidContent() {
        return oidContent;
    }

    public void setOidContent(String oidContent) {
        this.oidContent = oidContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
