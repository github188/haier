package com.haier.test;

import com.google.common.collect.Maps;
import com.haier.common.ObjectUtils;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.domain.ServiceOrder;
import com.haier.domain.hp.HPAddWoDataRequest;
import com.haier.domain.hp.HPAddWoDataRequestBuilder;
import com.haier.domain.hp.HPAddWoDataResponse;
import com.haier.service.hp.HPFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
public class HpTest {



    public static void main(String[]args){
//
        try {
            hpOrderTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Map<String,String> maps = Maps.newHashMap();
//        maps.put()

//        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//        HPFacade facade = ap.getBean(HPFacade.class);
//        try {
//            HPAddWoDataResponse response = facade.executeAddWoData(getAddRequest());
//            System.out.print(response.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static HPAddWoDataRequest getAddRequest(){
        return HPAddWoDataRequestBuilder.create()
                .setApply_id("leixwksdjaflsd").setProduct_id("16")
                .setService_type("T01").setRequire_service_date("2016-06-06 17:00:00")
                .setCustomer_name("雷晓武").setMobile_phone("15022086097")
                .setDistrict("120103").setAddress("天津市河西区福建路4号").setRequire_service_desc("安装")
                .setService_time("2016-06-06 17:00:00-2016-06-06 18:00:00").build();
    }
    static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void hpOrderTest() throws Exception {
        ServiceOrder serviceOrder = new ServiceOrder();
//                serviceOrder.setApply_id("leixwksdjaflsd");
        serviceOrder.setProduct_id("16");
        serviceOrder.setService_type("T01");
        serviceOrder.setRequire_time(new Date());
        serviceOrder.setCotact_name("李");
        serviceOrder.setMobile_phone("15022086097");
        serviceOrder.setDistrict("120103");
        serviceOrder.setService_address("天津市河西区福建路4号");
        serviceOrder.setRequire_service_desc("测试安装");
        serviceOrder.setOrder_time(new Date());
        serviceOrder.setService_time("2016-06-06 17:00:00-2016-06-06 17:00:00");
        String  json =  HEHttpClients.httpGetExecute("http://localhost:9000/api/haier/1.0/order/newOrder", ObjectUtils.toMap(serviceOrder));
        System.out.println(json);
    }
}
