package com.haier.controller.api;

import com.google.common.base.Strings;
import com.haier.common.ApplyIdGenerate;
import com.haier.common.response.ResponseBody;
import com.haier.common.response.ResponseConstantCode;
import com.haier.common.response.ResponseMsg;
import com.haier.controller.BaseController;
import com.haier.domain.ServiceOrder;
import com.haier.qrcode.domain.GetOIDProductInfoInput;
import com.haier.qrcode.domain.GetOIDProductInfoOutput;
import com.haier.service.OrderService;
import com.haier.service.QRService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/6/9.
 */
@Controller
@RequestMapping("/haier/1.0/qr")
public class QRController extends BaseController{
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private QRService qrService;

    @RequestMapping(path = "/getOidProductInfo",method = RequestMethod.POST)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody newOrder(@RequestBody GetOIDProductInfoInput input){
        if(Strings.isNullOrEmpty(input.getOidContent())){
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
        GetOIDProductInfoOutput output = null;
        try{
            output = qrService.getOIDProductInfo(input.getOidContent());
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE, ex.getMessage());
        }
        ResponseMsg msg =  new ResponseMsg<GetOIDProductInfoOutput>(ResponseConstantCode.SUCCESS_CODE, ResponseConstantCode.SUCCESS_DESC);
        msg.setInfo(output);
        return msg;
    }
}
