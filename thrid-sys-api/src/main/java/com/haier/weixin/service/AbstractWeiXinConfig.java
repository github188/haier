package com.haier.weixin.service;

import com.alibaba.fastjson.JSONObject;
import com.haier.ThridSysConfig;
import com.haier.utils.HEIDSAPIClient;
import com.haier.weixin.domain.WeiXinRequest;
import com.haier.weixin.domain.WeiXinRequestBody;

/**
 * Created by ehl on 2016/6/11.
 */
public class AbstractWeiXinConfig extends ThridSysConfig{

    public HEIDSAPIClient getHttpClient(){
        return new HEIDSAPIClient(getWxUrl(), getSecretKey(), getDigestAlgorithm(), getResponseType());
    }
    /**
     * subscribe request
     * @param content
     * @param from
     * @return
     */
    public WeiXinRequest getSubscribe(String content,String from){
        return new WeiXinRequest("subscribe",new WeiXinRequestBody(content,from));
    }

    /**
     * request json
     * @param content
     * @param from
     * @return
     */
    public String getSubscribeJson(String content,String from){
        return JSONObject.toJSONString(getSubscribe(content,from));
    }

    /**
     * 注册
     * @param content
     * @param from
     * @return
     */
    public WeiXinRequest getUserRegister(String content,String from){
        return new WeiXinRequest("userRegister",new WeiXinRequestBody(content,from));
    }

    /**
     *
     * @param content
     * @param from
     * @return
     */
    public String getUserRegisterJson(String content,String from){
        return  JSONObject.toJSONString(getUserRegister(content,from));
    }

    /**
     *
     * @param content
     * @param from
     * @return
     */
    public WeiXinRequest getUserActivate(String content,String from){
        return new WeiXinRequest("userActivate",new WeiXinRequestBody(content,from));
    }

    /**
     *
     * @param content
     * @param from
     * @return
     */
    public String getUserActivateJson(String content,String from){
        return JSONObject.toJSONString(getUserActivate(content,from));
    }
}
