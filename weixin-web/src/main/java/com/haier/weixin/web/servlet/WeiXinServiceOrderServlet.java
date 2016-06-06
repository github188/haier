package com.haier.weixin.web.servlet;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.common.response.PropertiesLoaderUtils;
import com.haier.weixin.web.domain.ServiceOrder;
import com.haier.weixin.web.utils.ObjectUtils;
import com.haier.weixin.web.utils.RequestUtils;
import com.haier.weixin.web.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * //        Map<String,String> maps=req.getParameterMap();
 //        Map<String,String> requestMaps= Maps.newHashMap();
 //        try {
 //            for(String parameter:reqName){
 //                if(!maps.containsKey(parameter)){
 //                    ResponseUtils.returnInfo(resp, 500, "{'code':-3,'message':'参数不存在 "+parameter+"'}");
 //                    return ;
 //                }
 //                String value=maps.get(parameter);
 //                if(Strings.isNullOrEmpty(value)){
 //                    ResponseUtils.returnInfo(resp, 500, "{'code':-3,'message':'参数值为空 "+parameter+"'}");
 //                    return ;
 //                }
 //                requestMaps.put(parameter,value);
 //            }
 //
 //            for(String o:other){
 //                if(maps.containsKey(o)){
 //                    requestMaps.put(o,maps.get(o));
 //                }
 //            }
 //
 //        } catch (Exception e){
 //            e.printStackTrace();
 //            if(e instanceof NullPointerException){
 //                ResponseUtils.returnInfo(resp, 500, "{'code':-3,'message':'"+e.getMessage()+"'}");
 //            }else{
 //                ResponseUtils.returnInfo(resp, 500, "{'code':-2,'message':'"+e.getLocalizedMessage()+"'}");
 //            }
 //        }
 * Created by ehl on 2016/6/5.

 private Date require_time;-->require_service_date
 private String cotact_name;-->contact_name
 private String district;--->code
 private String service_address --->;address
 */
public class WeiXinServiceOrderServlet extends HttpServlet {
    private List<String> reqName= Lists.newArrayList("product_id","service_type","require_service_date",
            "contact_name",
            "mobile_phone","district","address","require_service_desc","service_time");
    private Logger logger = LoggerFactory.getLogger(getClass());
    private List<String> other=Lists.newArrayList("user_id","order_time","arrive_time","service_man_id");
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
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceOrder order = new ServiceOrder();
        order.setContact_name(req.getParameter("contact_name"));
        order.setDistrict(req.getParameter("district"));
        order.setMobile_phone(req.getParameter("mobile_phone"));
        order.setProduct_id(req.getParameter("product_id"));
        order.setRequire_service_desc(req.getParameter("require_service_desc"));
        String req_time = req.getParameter("require_service_date");
        if(Strings.isNullOrEmpty(req_time)){
            ResponseUtils.returnInfo(resp, 500, "{'code':-3,'message':'参数date不能为空''}");
            return;
        }
        try {
            order.setRequire_service_date(sdf.parse(req_time));
        } catch (ParseException e) {
            ResponseUtils.returnInfo(resp, 500, "{'code':-3,'message':'参数date转换问题 '}");
            return;
        }
        order.setService_time(req.getParameter("service_time"));
        order.setService_type(req.getParameter("service_type"));
//        order.set

        try {
            String result = HEHttpClients.httpPostExecute(serviceUrl, ObjectUtils.toMap(order));
            ResponseUtils.returnInfo(resp,200,result);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtils.returnInfo(resp, 500, "{'code':-2,'message':'"+e.getLocalizedMessage()+"'}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
