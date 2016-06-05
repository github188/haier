package com.haier.test;

import com.haier.domain.hp.HPAddWoDataRequest;
import com.haier.domain.hp.HPAddWoDataRequestBuilder;
import com.haier.domain.hp.HPAddWoDataResponse;
import com.haier.service.hp.HPFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ehl on 2016/6/5.
 */
public class HpTest {

    public static HPAddWoDataRequest getAddRequest(){
        return HPAddWoDataRequestBuilder.create()
                .setApply_id("leixwksdjaflsd").setProduct_id("16")
                .setService_type("T01").setRequire_service_date("2016-06-05 17:00:00")
                .setCustomer_name("雷晓武").setMobile_phone("15022086097")
                .setDistrict("120103").setAddress("天津市河西区福建路4号").setRequire_service_desc("安装")
                .setService_time("2016-06-05 17:00:00-2016-06-05 17:00:00").build();
    }

    public static void main(String[]args){


        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        HPFacade facade = ap.getBean(HPFacade.class);
        try {
            HPAddWoDataResponse response = facade.executeAddWoData(getAddRequest());
            System.out.print(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
