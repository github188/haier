package com.haier.weixin.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.common.response.PropertiesLoaderUtils;
import com.haier.weixin.web.domain.WXAccessDomain;
import com.haier.weixin.web.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by ehl on 2016/6/11.
 */
public class RedirectPageServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Properties properties;
    private String access_token_url="";
    //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6b17940db3bd4c51&redirect_uri=http://hrfwtest.haier.net/weixin-web/redirect?heType=index&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
    @Override
    public void init() throws ServletException{
        try {
            properties= PropertiesLoaderUtils.loadAllProperties("config.properties");
            access_token_url=properties.getProperty("wx.fetch.access.tocken","https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6b17940db3bd4c51&secret=aac91e95b920141d4fe8e3d6483931ae&code={0}&grant_type=authorization_code");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type=req.getParameter("heType");
        String code=req.getParameter("code");
        if(Strings.isNullOrEmpty(code)){
            req.getRequestDispatcher("error.jsp").forward(req,resp);
            return;
        }
        access_token_url=MessageFormat.format(access_token_url,code);
        WXAccessDomain wxAccessDomain;
        try {
            logger.info(access_token_url);
           String wxResponse=HEHttpClients.httpGetExecute(access_token_url);
            logger.error(wxResponse);
            wxAccessDomain=JSONObject.parseObject(wxResponse,WXAccessDomain.class);
            logger.info(wxAccessDomain.toString());
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtils.returnInfo(resp,500,"{'code':-3,'message':'wx系统异常'"+e.getMessage()+"'}");
            return;
        }
        String responseJsp="index.jsp";
        switch (type){
            //维修
            case "maintain":
                responseJsp="maintence.jsp";
                break;
            case "index":
                responseJsp="index.jsp";
                break;
            case "servicelist":
                responseJsp="servicelist.jsp";

                break;
            default:
                break;
        }
//        req.getRequestDispatcher(responseJsp+"?openId="+wxAccessDomain.getOpenid()).forward(req,resp);
        resp.sendRedirect(responseJsp+"?openId="+wxAccessDomain.getOpenid());//.forward(req,resp);
        //resp.sendRedirect(responseJsp+"?openId=oZqEpv9ujQa9Q2wkQYhexn-UhU0M");
//      resp.sendRedirect(responseJsp+"?openId="+1);//.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
