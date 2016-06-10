package com.haier.test;

import com.haier.domain.User;
import com.haier.service.UserService;
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
        UserService service = ap.getBean(UserService.class);
        try {
            User user = new User();
            user.setUserName("bright");
            user.setPassword("123456");
            service.clearAccessToken(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
