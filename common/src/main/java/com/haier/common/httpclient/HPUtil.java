package com.haier.common.httpclient;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/5.
 */
public class HPUtil {
    public static ReturnMessage methodInvoke(String methodName, Object param){
        StringBuffer sb = new StringBuffer();
        try {
            String url = "http://58.56.128.105:8080/rrs/center";//配置文件
            String method = methodName;
            Long timestamp = new Date().getTime();
            String access_token = "ZmQwNTk1MDgtZDY5Yi00M2FiLTk4NWQtNDVmZjEwMzZkOTVh";//配置文件
            StringBuffer result = new StringBuffer();
            result.append(url);
            result.append("?method=" + method);
            result.append("&timestamp=" + timestamp);
            result.append("&access_token="+access_token);
            if(param != null){
                for(Field field:param.getClass().getDeclaredFields()){
                    String key = field.getName();
                    Object value = param.getClass().getDeclaredMethod("get"+toUpperCaseFirstOne(key)).invoke(param);
                    if(value != null && !"".equals(value)){
                        result.append("&"+key+"="+value);
                    }
                }
            }
            URL finalurl = new URL(result.toString());
            HttpURLConnection connection = (HttpURLConnection) finalurl.openConnection();
            connection.setRequestProperty("user-agent",
                    "mozilla/4.0 (compatible; msie 6.0; windows 2000)");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(30000);
            connection.connect();
            System.out.println("--debug myurl:" + result.toString() + ",length:"
                    + connection.getContentLength() + ",status:"
                    + connection.getResponseCode());
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();
                BufferedReader breader = new BufferedReader(new InputStreamReader(
                        in, "gbk"));
                String str = breader.readLine();
                while (str != null) {
                    sb.append(str);
                    str = breader.readLine();
                }
                in.close();
            }
            connection.disconnect();
            connection = null;
            finalurl = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.parseObject(sb.toString(),ReturnMessage.class);
    }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static void main(String[] args){
        ReturnMessage returnMessage = methodInvoke("rrs.gis.get.regionNew",null);
        System.out.println(returnMessage);
    }

}
