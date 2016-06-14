package com.haier.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.haier.common.response.ResponseBody;
import com.haier.common.response.ResponseConstantCode;
import com.haier.common.response.ResponseMsg;
import com.haier.controller.BaseController;
import com.haier.domain.User;
import com.haier.service.UserService;
import com.haier.weixin.domain.WeiXinResponse;
import com.haier.weixin.service.WeiXinFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 雷晓武 on 2016/6/12.
 */
@Controller
@RequestMapping("/haier/1.0/wxuser")
public class WeiXinUserController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(path="/isExist/{openId}",method= RequestMethod.GET)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody isExist(@PathVariable String openId){
        if(Strings.isNullOrEmpty(openId)){
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
        try {
            String userId= userService.isExistWithOpenId(openId);
            ResponseMsg body = getSuccess();
            JSONObject info = new JSONObject();
            info.put("user_id",userId);
            body.setInfo(info);
            return body;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ResponseConstantCode.INTERNAL_ERROR_DESC);
        }
//        try{
//            user = userService.addNewUser(user);
//        }catch(Exception ex){
//            logger.error(ex.getMessage());
//            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ex.getMessage());
//        }
//        ResponseMsg message = new ResponseMsg(ResponseConstantCode.SUCCESS_CODE,ResponseConstantCode.SUCCESS_DESC);
//        JSONObject info = new JSONObject();
//        info.put("user_id",user.getId());
//        info.put("access_token",user.getAccessToken());
//        message.setInfo(info);
//        return message;
    }
    @Autowired
    private WeiXinFacade weiXinFacade;
    @RequestMapping(path="/sendCode/{openId}/{user}",method= RequestMethod.GET)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody sendCode(@PathVariable String openId,@PathVariable String user) {
        if (Strings.isNullOrEmpty(openId) ||Strings.isNullOrEmpty(user)) {
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE, ResponseConstantCode.INVALID_PARAMETER_DESC);
        }


        try {
            WeiXinResponse response = weiXinFacade.userRegister(user,openId);
            if(response.getIsAskNextRequest().equals("false")){
                //已经注册
            }
            return getSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ResponseConstantCode.INTERNAL_ERROR_DESC);
        }
    }
    @RequestMapping(path="/register/{openId}/{user}/{code}",method= RequestMethod.GET)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody register(@PathVariable String openId,@PathVariable String user,@PathVariable String code) {
        if (Strings.isNullOrEmpty(openId) ||Strings.isNullOrEmpty(user) ||Strings.isNullOrEmpty(code)) {
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE, ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
        try {
            String msg=userService.wxRegister(openId,user,code);
            ResponseMsg responseMsg =  getSuccess();
            JSONObject object = new JSONObject();
            object.put("user_msg",msg);
            responseMsg.setInfo(object);
            return responseMsg;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ResponseConstantCode.INTERNAL_ERROR_DESC);
        }
    }

}
