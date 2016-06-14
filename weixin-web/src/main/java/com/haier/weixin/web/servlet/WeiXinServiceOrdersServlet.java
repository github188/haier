package com.haier.weixin.web.servlet;

import com.google.common.collect.Maps;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.weixin.web.utils.ObjectUtils;
import com.haier.weixin.web.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by 雷晓武 on 2016/6/14.
 * var jsonData = {
 "user_id":user_id,
 "status":status,
 "pageNumber":offset,
 "pageSize":_pageSize
 }
 */
public class WeiXinServiceOrdersServlet extends AbstractServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("user_id");
        String status=req.getParameter("status");
        String pageNumber = req.getParameter("pageNumber");
        String pageSize = req.getParameter("pageSize");
        String serviceUrl = properties.getProperty("haier.service.order.list");

        Map<String,Object> maps = Maps.newHashMap();
        maps.put("user_id",userId);
        maps.put("status",status);
        maps.put("pageNumber",pageNumber);
        maps.put("pageSize",pageSize);
        try {
            String result = HEHttpClients.httpJsonPostExecute(serviceUrl, maps,getWXHeader());
            ResponseUtils.returnInfo(resp,200,result);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtils.returnInfo(resp, 500, "{'code':-2,'message':'"+e.getLocalizedMessage()+"'}");
        }
    }
}
