//package com.haier.weixin.web;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import com.haier.common.httpclient.HEHttpClients;
//import com.haier.weixin.web.domain.ServiceOrder;
//import com.haier.weixin.web.utils.ObjectUtils;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by ehl on 2016/6/6.
// */
//public class TestHp {
//    private List<String> reqName= Lists.newArrayList("product_id", "service_type", "require_service_date",
//            "contact_name",
//            "mobile_phone", "code", "address", "require_service_desc", "service_time");
//
//    private List<String> other=Lists.newArrayList("user_id","order_time","arrive_time","service_man_id","");
//    public static void hpOrderTest() throws Exception {
////        ServiceOrder serviceOrder = new ServiceOrder();
//////                serviceOrder.setApply_id("leixwksdjaflsd");
////        serviceOrder.setProduct_id("16");
////        serviceOrder.setService_type("T01");
////        serviceOrder.setRequire_time(new Date());
////        serviceOrder.setContact_name("李先生");
////        serviceOrder.setMobile_phone("15022086097");
////        serviceOrder.setDistrict("120103");
////        serviceOrder.setService_address("天津市河西区福建路4号");
////        serviceOrder.setRequire_service_desc("测试安装");
////        serviceOrder.setOrder_time(new Date());
////        serviceOrder.setService_time("2016-06-06 17:00:00-2016-06-06 17:00:00");
//
//        Map<String,String> maps = Maps.newHashMap();
//        maps.put("product_id","16");
//        maps.put("service_type","T01");
//        maps.put("require_service_date","2016-06-07 08:00:00");
//        maps.put("contact_name","李先生");
//        maps.put("mobile_phone","15022086097");
//        maps.put("code","120103");
//        maps.put("address","天津市河西区福建路4号");
//        maps.put("require_service_desc","测试安装");
//        maps.put("service_time","2016-06-07 08:00:00-2016-06-07 09:00:00");
//        String  json =  HEHttpClients.httpPostExecute("http://localhost:9080/weixin-web/serviceOrder",maps );
//        System.out.println(json);
//    }
//}
