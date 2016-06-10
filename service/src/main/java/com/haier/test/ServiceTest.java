package com.haier.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by ehl on 2016/6/4.
 */
public class ServiceTest {
    public static void main(String[]args){
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ThridSysConfig service = ap.getBean(ThridSysConfig.class);
        TestService service = ap.getBean(TestService.class);
        try {
            service.readCityJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
