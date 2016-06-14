package com.haier.weixin.web.servlet;

import com.google.common.base.Strings;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.common.response.PropertiesLoaderUtils;
import com.haier.weixin.web.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/5.
 */
public class WeiXinCommonServlet extends AbstractServlet{
    private String serviceUrl;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
            doPost(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
            String type = req.getParameter("type");
            String code = req.getParameter("code");
            boolean needCode = false;
            if("brand".equals(type)){
                serviceUrl = properties.getProperty("haier.service.common.brand.url","");
            }else if("type".equals(type)){
                needCode = true;
                serviceUrl = properties.getProperty("haier.service.common.type.url","")+"/"+code;
            }else if("subType".equals(type)){
                needCode = true;
                serviceUrl = properties.getProperty("haier.service.common.subType.url","")+"/"+code;
            }
            if(needCode && Strings.isNullOrEmpty(code)){
                    ResponseUtils.returnInfo(resp, 500, "{'code':-3,'message':'parameter is null'}");
            }
        try {

            String result = HEHttpClients.httpGetExecute(serviceUrl,getWXHeader());
            ResponseUtils.returnInfo(resp,200,result);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtils.returnInfo(resp,500,"{'code':-3,'message':'系统异常'}");
        }
    }
}
