package com.haier.qrcode.service;

import com.haier.ThridSysConfig;
import com.haier.qrcode.domain.GetOIDProductInfoInput;
import com.haier.qrcode.wsclient.OIDProductInfo;
import com.haier.qrcode.wsclient.OIDProductInfoLocator;
import com.haier.qrcode.wsclient.OIDProductInfoSoap;
import com.haier.qrcode.wsclient.OIDProductInfoSoapStub;

import java.net.URL;

/**
 * Created by Administrator on 2016/6/9.
 */
public class AbstractEaiSys extends ThridSysConfig{
    public OIDProductInfoSoap getProductInfoWSClient() throws Exception {
        OIDProductInfo service = new OIDProductInfoLocator();
        URL serviceUrl = getProductInfoWSUrl();
        OIDProductInfoSoap client = new OIDProductInfoSoapStub(serviceUrl,service);
        return client;
    }
    public void addOIDProductInfoDefaultParam(GetOIDProductInfoInput input){
        input.setUserName(getEaiUserName());
        input.setPwd(getEaiPassword());
    }
    private URL getProductInfoWSUrl() throws Exception{
        return new URL(getEaiUrl()+getEaiProductInfoUrlSuffix());
    }
}
