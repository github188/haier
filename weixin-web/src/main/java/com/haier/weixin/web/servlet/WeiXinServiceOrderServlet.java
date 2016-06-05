package com.haier.weixin.web.servlet;

import com.haier.common.httpclient.HEHttpClients;
import com.haier.common.response.PropertiesLoaderUtils;
import com.haier.weixin.web.utils.RequestUtils;
import com.haier.weixin.web.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
            serviceUrl = properties.getProperty("haier.service.order.url","http://115.28.231.67:8080/api/haier/1.0/order/newOrder");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> maps=null;
        try {
            maps=RequestUtils.matchParameterWithOrder(req);
        } catch (Exception e){
            e.printStackTrace();
            if(e instanceof NullPointerException){
                ResponseUtils.returnInfo(resp, 500, "{'code':-3,'message':'"+e.getMessage()+"'}");
            }else{
                ResponseUtils.returnInfo(resp, 500, "{'code':-2,'message':'系统异常'}");
            }
        }

        try {
            String result = HEHttpClients.httpGetExecute(serviceUrl,maps);
            ResponseUtils.returnInfo(resp,200,result);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtils.returnInfo(resp, 500, "{'code':-2,'message':'系统异常'}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
