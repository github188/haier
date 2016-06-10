package com.haier.weixin;

import com.haier.utils.HEIDSAPIClient;

/**
 * Created by ehl on 2016/6/10.
 */
public class Test {
    private static String idsUrl = "http://tuser.haier.com/ids";
    private static String serviceUrl = idsUrl
            + "/service?idsServiceType=wxService&type=HaierWeixinAction&action=userRegister&appWeixinID=gh_620462d9b1ad";

    public static void main(String[] args) throws Exception {

        String params = "{'action':'userRegister','body':{'content':'15022086097','fromUserName':'dsfd','msgType':'text','toUserName':'gh_620462d9b1ad'}}";
        HEIDSAPIClient ids = new HEIDSAPIClient(serviceUrl, "Q1E3G5J6", "MD5", "json");
        String infos = ids.processor("weixinTest2", params);
        System.out.println(infos);
    }
}
