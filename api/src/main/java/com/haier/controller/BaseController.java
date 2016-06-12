package com.haier.controller;


import com.haier.common.response.ResponseBody;
import com.haier.common.response.ResponseConstantCode;
import com.haier.common.response.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_DESC = "errorDesc";
    
    public static final String RESULT_CODE = "resultCode";
    public static final String RESULT_DESC = "resultDesc";
    protected ResponseMsg getSuccess(){
        return new ResponseMsg(ResponseConstantCode.SUCCESS_CODE,ResponseConstantCode.SUCCESS_DESC);
    }
}
