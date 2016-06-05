package com.haier.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.haier.common.ResponseBody;
import com.haier.common.ResponseConstantCode;
import com.haier.common.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_DESC = "errorDesc";
    
    public static final String RESULT_CODE = "resultCode";
    public static final String RESULT_DESC = "resultDesc";
    protected ResponseBody getSuccess(){
        return new ResponseMsg(ResponseConstantCode.SUCCESS_CODE,ResponseConstantCode.SUCCESS_DESC);
    }
}
