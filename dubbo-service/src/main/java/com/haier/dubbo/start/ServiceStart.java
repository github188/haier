package com.haier.dubbo.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by ehl on 2016/6/8.
 */
public class ServiceStart {

    public static void main(String[] args) throws IOException {

//        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("dubbo.properties");
//        while (urls.hasMoreElements()) {
//            URL url = urls.nextElement();
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + url.getFile());
//        }
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","dubbo-service.xml"});
    context.start();

    System.in.read(); // 按任意键退出
    }
}
