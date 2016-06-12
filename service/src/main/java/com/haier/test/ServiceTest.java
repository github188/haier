package com.haier.test;

import com.haier.common.response.Page;
import com.haier.common.token.Token;
import com.haier.domain.ServiceOrder;
import com.haier.domain.ServiceOrderTrace;
import com.haier.domain.User;
import com.haier.hp.domain.HPWoListData;
import com.haier.service.OrderService;
import com.haier.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by ehl on 2016/6/4.
 */
public class ServiceTest {
    public static void main(String[]args){
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ThridSysConfig service = ap.getBean(ThridSysConfig.class);
        OrderService service = ap.getBean(OrderService.class);
        try {
//            User user = new User();
//            user.setId(1);
//            Page<ServiceOrder> page = new Page<ServiceOrder>();
//            page.setPageNumber(1);
//            page.setPageSize(3);
//            page = service.getOrderListPage(user,page);
//            System.out.println(page);
            List<ServiceOrderTrace> list = service.getServiceOrderTrack("BXK3160606115337");
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
