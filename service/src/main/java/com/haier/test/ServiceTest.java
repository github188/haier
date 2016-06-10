package com.haier.test;

import com.haier.common.token.Token;
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
//            User user = new User();
//            user.setUserName("bright");
//            user.setPassword("123456");
//            user.setPhone("123456");
//            user = service.addNewUser(user);
//            System.out.println(user);
            String userkey = "960D0F073667E20BFFD3B61E149FC2CF";
            String t =Long.toString(System.currentTimeMillis());
            String m = Token.getTokenM(t,userkey);
            System.out.println(t);
            System.out.println(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
