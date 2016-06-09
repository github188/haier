package com.haier.test;
import com.haier.common.ObjectUtils;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.domain.ServiceOrder;
import com.haier.hp.domain.HPAddWoDataRequest;
import com.haier.hp.domain.HPAddWoDataRequestBuilder;
import com.haier.hp.domain.HPAddWoDataResponse;
import com.haier.hp.service.HPFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */

public class HpTest {



    public static void main(String[]args) throws Exception {
//        Map<String,String> maps = Maps.newHashMap();
//        maps.put("foo","sdfsdf");
//        maps.put("fruit","kds");
//        String result = HEHttpClients.httpJsonPostExecute("http://localhost:8080/spring-mvc-showcase/messageconverters/json",maps);
//        System.out.println(result);
//
        try {
            hpOrderTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Map<String,String> maps = Maps.newHashMap();
//        maps.put()

//        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationThridSys.xml");
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
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void hpOrderTest() throws Exception {
        ServiceOrder serviceOrder = new ServiceOrder();
//                serviceOrder.setApply_id("leixwksdjaflsd");
        serviceOrder.setProduct_id("16");
        serviceOrder.setService_type("T01");
//        serviceOrder.setRequire_service_date(sdf.parse("2016-06-09 18:18:00"));
        serviceOrder.setRequire_service_date(new Date());
        serviceOrder.setContact_name("李");
        serviceOrder.setMobile_phone("15022086097");
        serviceOrder.setDistrict("120103");
        serviceOrder.setAddress("天津市河西区福建路4号");
        serviceOrder.setRequire_service_desc("测试安装");
        serviceOrder.setOrder_time(new Date());
        serviceOrder.setService_time("2016-06-06 17:00:00-2016-06-06 17:00:00");
        Map<String,Object> maps= ObjectUtils.toMap(serviceOrder);
//        maps.put()
        String  json =  HEHttpClients.httpJsonPostExecute("http://localhost:9090/api/haier/1.0/order/newOrder", maps);
        System.out.println(json);
    }
}
