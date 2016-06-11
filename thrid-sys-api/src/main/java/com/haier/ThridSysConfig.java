package com.haier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ehl on 2016/6/5.
 */
@Component
public class ThridSysConfig {
    @Value("#{config['hp.url']}")
    public String hpUrl;
    @Value("#{config['hp.access.token']}")
    public String hpToken;
    @Value("#{config['eai.url']}")
    public String eaiUrl;
    @Value("#{config['eai.url.suffix.productinfo']}")
    public String eaiProductInfoUrlSuffix;
    @Value("#{config['eai.username']}")
    public String eaiUserName;
    @Value("#{config['eai.password']}")
    public String eaiPassword;

    @Value("#{config['wx.url']}")
    public String wxUrl;
    @Value("#{config['wx.secretKey']}")
    public String secretKey;
    @Value("#{config['wx.digestAlgorithm']}")
    public String digestAlgorithm;
    @Value("#{config['wx.responseType']}")
    public String responseType;
    @Value("#{config['wx.appName']}")
    public String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getWxUrl() {
        return wxUrl;
    }

    public void setWxUrl(String wxUrl) {
        this.wxUrl = wxUrl;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getHpUrl() {
        return hpUrl;
    }

    public void setHpUrl(String hpUrl) {
        this.hpUrl = hpUrl;
    }

    public String getHpToken() {
        return hpToken;
    }

    public void setHpToken(String hpToken) {
        this.hpToken = hpToken;
    }

    public String getEaiPassword() {
        return eaiPassword;
    }

    public void setEaiPassword(String eaiPassword) {
        this.eaiPassword = eaiPassword;
    }

    public String getEaiUrl() {
        return eaiUrl;
    }

    public void setEaiUrl(String eaiUrl) {
        this.eaiUrl = eaiUrl;
    }

    public String getEaiUserName() {
        return eaiUserName;
    }

    public void setEaiUserName(String eaiUserName) {
        this.eaiUserName = eaiUserName;
    }

    public String getEaiProductInfoUrlSuffix() {
        return eaiProductInfoUrlSuffix;
    }

    public void setEaiProductInfoUrlSuffix(String eaiProductInfoUrlSuffix) {
        this.eaiProductInfoUrlSuffix = eaiProductInfoUrlSuffix;
    }

}
