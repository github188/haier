package com.haier.weixin.web.servlet;

import com.haier.common.httpclient.HEHttpClients;
import com.haier.common.response.PropertiesLoaderUtils;
import com.haier.weixin.web.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ehl on 2016/6/5.
 */
public class WeiXinServiceOrderServlet extends HttpServlet {
    private String serviceUrl;
    @Override
    public void init() throws ServletException {
        try {
            Properties properties= PropertiesLoaderUtils.loadAllProperties("config.properties");
            serviceUrl = properties.getProperty("","");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> map = req.getParameterMap();

        try {
            String result = HEHttpClients.httpGetExecute(serviceUrl,map);
            ResponseUtils.returnInfo(resp,200,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
