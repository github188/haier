package com.haier.weixin.web;

import com.haier.common.httpclient.HEHttpClients;

import java.text.MessageFormat;

/**
 * Created by ehl on 2016/6/11.
 */
public class Test {
    public static void main(String[]args) throws Exception {
        //{"access_token":"Xt_Z3kaKtKPEwzugE0PQNW0KvE3yq20uIOCga-Mu5bI698ibDsEuVJZJOlghcebzs1BF7xZgQFLykSYWZZliQz6KvaQZm-Z-aIYROHEq7rw","expires_in":7200,"refresh_token":"Yu8TCS3_UsuzYnr60VbfwMgvcRjozlsImUSQvjQbj7b6fskTF5UX6SU3c8kmLb08qGyE1ksJjDwDl2_77onY_C-uM6x-1tbJ_dbhMjNmCIk","openid":"oZqEpv9ujQa9Q2wkQYhexn-UhU0M","scope":"snsapi_base"}
        //{"access_token":"LNoXWYjLyAyROU4iPpObEb3wB00-8s9-NAl-Vo9YkBwHoCQIbn1Z4jrD0B3ZbBckFUgMDK0H2HhjUyr5ps1pXS8hs3NenvWsuoTm1-v4Qcw","expires_in":7200,"refresh_token":"Yu8TCS3_UsuzYnr60VbfwErowBfTy_fKo3aYzU4FYjtiX7-GNoOucqycVLRRESkEWcf6x1czgXacSSFibdFv6sTLCieg4LbhcQhZVr23Vh4","openid":"oZqEpv9ujQa9Q2wkQYhexn-UhU0M","scope":"snsapi_base"}

        String str="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6b17940db3bd4c51&secret=aac91e95b920141d4fe8e3d6483931ae&code={0}&grant_type=authorization_code";
        str=MessageFormat.format(str,"0119cvo41DfBVZ1FNKm41RRxo419cvov");
//        System.out.println(str);
        String json=HEHttpClients.httpGetExecute(str);
        System.out.println(json);
    }
}
