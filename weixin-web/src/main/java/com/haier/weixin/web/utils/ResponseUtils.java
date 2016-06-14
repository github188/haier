package com.haier.weixin.web.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ehl on 2016/6/5.
 */
public class ResponseUtils {
    private static Logger logger = LoggerFactory.getLogger(ResponseUtils.class);
    private static final String CHARSET = "UTF-8";
    public static void returnInfo( HttpServletResponse response, int httpStatusCode, String returnInfo) throws IOException {
        response.setStatus(httpStatusCode);
        response.setCharacterEncoding(CHARSET);
        response.setContentType("application/json; charset=utf-8");
        if (returnInfo != null && returnInfo.trim().length() > 0) {
            PrintWriter out = response.getWriter();
            logger.info("返回终端数据：" + returnInfo);
            out.print(returnInfo);
            out.flush();
            out.close();
        } else {
            logger.info("本次请求无返回数据！");
        }
    }

    protected void returnInfo( HttpServletResponse response, int httpStatusCode) throws IOException {
        response.setStatus(httpStatusCode);
        logger.info(httpStatusCode + "本次请求无返回数据！");
    }

    protected void returnInfo( HttpServletResponse response, int httpStatusCode, JSONObject returnJson) throws IOException {
        if (returnJson == null || returnJson.isEmpty()) {
            returnInfo( response, httpStatusCode);
        } else {
            returnInfo( response, httpStatusCode, returnJson.toString());
        }
    }

    protected void returnInfo( HttpServletResponse response, int httpStatusCode, JSONArray returnJsonArray) throws IOException {
        logger.info("本次请求结果状态码：" + httpStatusCode);
        if (returnJsonArray == null || returnJsonArray.isEmpty()) {
            returnInfo( response, httpStatusCode);
        } else {
            returnInfo( response, httpStatusCode, returnJsonArray.toString());
        }
    }

    protected void returnInfo(HttpServletResponse response ,JSONObject json) throws IOException{
        returnInfo( response,json.getIntValue("code"),json.toJSONString());

    }

    protected void returnInfo(HttpServletResponse response ,JSONObject json,Integer code) throws IOException{
        returnInfo( response,code,json.toJSONString());

    }
}
