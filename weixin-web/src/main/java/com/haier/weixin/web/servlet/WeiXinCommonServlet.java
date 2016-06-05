package com.haier.weixin.web.servlet;

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
public class WeiXinCommonServlet extends HttpServlet{
    private String serviceUrl;
    private Properties properties;
    @Override
    public void init() throws ServletException {
        try {
             properties= PropertiesLoaderUtils.loadAllProperties("config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
            doPost(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
            String type = req.getParameter("type");
            String code = req.getParameter("code");
            if("brand".equals(type)){
                serviceUrl = properties.getProperty("haier.service.common.brand.url","");
            }else if("type".equals(type)){
                serviceUrl = properties.getProperty("haier.service.common.type.url","")+"/"+code;
            }else if("subType".equals(type)){
                serviceUrl = properties.getProperty("haier.service.common.subType.url","")+"/"+code;
            }
        try {
            String result = HEHttpClients.httpGetExecute(serviceUrl);
            ResponseUtils.returnInfo(resp,200,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
