package com.haier.weixin.web.servlet;


import com.haier.common.httpclient.HEHttpClients;
import com.haier.weixin.web.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 雷晓武 on 2016/6/14.
 */
public class WeiXinUserServlet extends AbstractServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type=req.getParameter("type");
        String openId=req.getParameter("openId");
        String url="";
        switch (type){
            case "isExist":
                 url= properties.getProperty("haier.service.user.isexist")+"/"+openId;

                break;
            case "sendCode":
                String phone=req.getParameter("phone");
                url=properties.getProperty("haier.service.user.sendcode")+"/"+openId+"/"+phone;
                break;
            case "register":
                String code=req.getParameter("code");
                String phone1=req.getParameter("phone");
                url=properties.getProperty("haier.service.user.register")+"/"+openId+"/"+phone1+"/"+code;
            default:
                break;
        }

        try {

            String result = HEHttpClients.httpGetExecute(url,getWXHeader());
            ResponseUtils.returnInfo(resp,200,result);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtils.returnInfo(resp,500,"{'code':-3,'message':'系统异常'}");
        }
    }
}
