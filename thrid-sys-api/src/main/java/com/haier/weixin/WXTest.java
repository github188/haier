package com.haier.weixin;


import com.haier.utils.HEIDSAPIClient;

public class WXTest {

	private static String idsUrl = "http://tuser.haier.com/ids";
	private static String serviceUrl = idsUrl
			+ "/service?idsServiceType=wxService&type=HaierWeixinAction&action=userRegister&appWeixinID=gh_620462d9b1ad";

	public static void main(String[] args) throws Exception {
//		String params = "{'action':'userActivate','body':{'content':'564301','fromUserName':'dsfd','msgType':'text','toUserName':'gh_620462d9b1ad'}}";
//		HEIDSAPIClient ids = new HEIDSAPIClient(serviceUrl, "Q1E3G5J6", "MD5", "json");
//		 	String infos = ids.processor("weixinTest2", params);
//			System.out.println(infos);
		String params = "{'action':'userRegister','body':{'content':'15902269561','fromUserName':'dsfd','msgType':'text','toUserName':'gh_620462d9b1ad'}}";
		HEIDSAPIClient ids = new HEIDSAPIClient(serviceUrl, "Q1E3G5J6", "MD5", "json");
		 	String infos = ids.processor("weixinTest2", params);
			System.out.println(infos);
//
//		System.out.println("======================================================");
//		String params1 = "{'action':'subscribe','body':{'content':'15022086097','fromUserName':'dsfd','msgType':'text','toUserName':'gh_620462d9b1ad'}}";
//		String url1 = "http://testuser.haier.com/ids/service?idsServiceType=wxService&type=HaierWeixinAction&action=subscribe&appWeixinID=gh_620462d9b1ad";
//		HEIDSAPIClient ids1 = new HEIDSAPIClient(serviceUrl, "Q1E3G5J6", "MD5", "json");
//		String infos1 = ids1.processor("weixinTest2", params1);
//		System.out.println(infos1);
	}

}
