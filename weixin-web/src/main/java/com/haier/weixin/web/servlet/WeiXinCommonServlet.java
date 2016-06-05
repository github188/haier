package com.haier.weixin.web.servlet;

import com.haier.common.httpclient.HEHttpClients;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/5.
 */
public class WeiXinCommonServlet extends HttpServlet{
    private final String  url="http://localhost:8080/";
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
            doPost(req,resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
            String type = req.getParameter("type");
            String code = req.getParameter("code");
            HashMap<String,String> param = new HashMap<String,String>();
            if("type".equals(type)){
                param.put("brandCode",code);
            }else if("subType".equals(type)){
                param.put("typeCode",code);
            }
        try {
            String result = HEHttpClients.httpGetExecute(url,param);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
