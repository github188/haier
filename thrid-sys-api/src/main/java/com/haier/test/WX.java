package com.haier.test;

/**
 * Created by 雷晓武 on 2016/6/12.
 */
public class WX {
    public static void main(String[]args){
        String str="您已成功注册海尔会员，登录账号15022086097默认密码vkbwdj；登录vip.haier.com互动赢好礼，免费获得家电保养,更多精彩尽在海尔";
        str=str.replace("您已成功注册海尔会员，登录账号","").replace("默认密码",";").replace("；登录vip.haier.com互动赢好礼，免费获得家电保养,更多精彩尽在海尔",";");
        System.out.println(str);
    }
}
