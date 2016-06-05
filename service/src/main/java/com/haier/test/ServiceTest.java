package com.haier.test;

import com.haier.service.ThridSysConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ehl on 2016/6/4.
 */
public class ServiceTest {
    public static void main(String[]args){
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        ThridSysConfig service = ap.getBean(ThridSysConfig.class);
        try {
           System.out.print(service.getHpToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
