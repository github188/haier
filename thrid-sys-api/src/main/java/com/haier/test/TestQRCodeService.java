package com.haier.test;


import com.haier.qrcode.domain.GetOIDProductInfoInput;
import com.haier.qrcode.domain.GetOIDProductInfoOutput;
import com.haier.qrcode.service.QRFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Administrator on 2016/6/9.
 */
public class TestQRCodeService {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationThridSys.xml");
        QRFacade service = applicationContext.getBean(QRFacade.class);
        GetOIDProductInfoInput input= new GetOIDProductInfoInput();
        input.setOidContent("http://oid.haier.com/oid?ewm=D006iM$MFTKA$AM$M$cM$KM$KKM$=$AM$Kv=Y$AM$$K$KA$KKM$FATMAK$FK=$KMKKYKKL4");
        GetOIDProductInfoOutput output = service.getOIDProductInfo(input);
        System.out.println(output);
    }
}
