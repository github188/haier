package com.haier.service.impl;

import com.haier.qrcode.domain.GetOIDProductInfoInput;
<<<<<<< HEAD
import com.haier.qrcode.domain.getOIDProductInfoOutput;
import com.haier.qrcode.service.QRFacade;
import com.haier.service.QRService;
=======
import com.haier.qrcode.domain.GetOIDProductInfoOutput;
import com.haier.qrcode.service.QRFacade;
import com.haier.service.QRService;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
>>>>>>> 73e080ce568c61d43f7e32d7ba9fc6972238ac2f
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/6/9.
 */
@Service("qrService")
public class QRServiceImpl implements QRService{
    @Autowired
    private QRFacade facade;
    @Override
<<<<<<< HEAD
    public getOIDProductInfoOutput getOIDProductInfo(String oidContent) throws Exception{
        GetOIDProductInfoInput input = new GetOIDProductInfoInput();
        input.setOidContent(oidContent);
        getOIDProductInfoOutput output = facade.getOIDProductInfo(input);
=======
    public GetOIDProductInfoOutput getOIDProductInfo(String oidContent) throws Exception{
        GetOIDProductInfoInput input = new GetOIDProductInfoInput();
        input.setOidContent(oidContent);
        GetOIDProductInfoOutput output = facade.getOIDProductInfo(input);
>>>>>>> 73e080ce568c61d43f7e32d7ba9fc6972238ac2f
        return output;
    }
}
