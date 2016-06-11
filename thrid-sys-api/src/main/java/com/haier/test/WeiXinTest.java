package com.haier.test;

import com.haier.qrcode.domain.GetOIDProductInfoInput;
import com.haier.qrcode.domain.GetOIDProductInfoOutput;
import com.haier.qrcode.service.QRFacade;
import com.haier.weixin.domain.WeiXinResponse;
import com.haier.weixin.service.WeiXinFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ehl on 2016/6/11.
 */
public class WeiXinTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationThridSys.xml");
        WeiXinFacade facade = applicationContext.getBean(WeiXinFacade.class);
        WeiXinResponse response = facade.userActivate("15022086097", "test");
        System.out.println(response.toString());
    }
}
