package com.haier.qrcode.service.impl;

import com.haier.common.JaxbUtil;
import com.haier.qrcode.domain.GetOIDProductInfoInput;
import com.haier.qrcode.domain.GetOIDProductInfoOutput;
import com.haier.qrcode.service.AbstractEaiSys;
import com.haier.qrcode.service.QRFacade;
import com.haier.qrcode.wsclient.OIDProductInfoSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/6/9.
 */
@Service
public class QRFacadeImpl extends AbstractEaiSys implements QRFacade{

    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public GetOIDProductInfoOutput getOIDProductInfo(GetOIDProductInfoInput input) throws Exception{
        logger.info("--------------------getOIDProductInfo-------------OidContent:"+input.getOidContent());
        OIDProductInfoSoap client = null;
        try {
            client = getProductInfoWSClient();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("get WSclient Failer");
        }
        addOIDProductInfoDefaultParam(input);
        String result = client.getProductInfo(input.getUserName(),input.getPwd(),input.getOidContent());
        GetOIDProductInfoOutput output = JaxbUtil.converyToJavaBean(result,GetOIDProductInfoOutput.class);
        return output;
    }
}
