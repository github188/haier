package com.haier.weixin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haier.weixin.domain.WeiXinResponse;
import com.haier.weixin.service.AbstractWeiXinConfig;
import com.haier.weixin.service.WeiXinFacade;
import org.springframework.stereotype.Service;

/**
 * Created by ehl on 2016/6/11.
 */
@Service
public class WeiXinFacadeImpl extends AbstractWeiXinConfig implements WeiXinFacade {
    @Override
    public WeiXinResponse subscribe(String context,String from) throws Exception {
        String json= getSubscribeJson(context,from);
        String response = getHttpClient().processor(getAppName(),json);
        return JSONObject.parseObject(response,WeiXinResponse.class);
    }

    @Override
    public WeiXinResponse userRegister(String context,String from) throws Exception {
        String json= getUserRegisterJson(context,from);
        String response = getHttpClient().processor(getAppName(),json);
        return JSONObject.parseObject(response,WeiXinResponse.class);
    }

    @Override
    public WeiXinResponse userActivate(String context,String from) throws Exception {
        String json= getUserActivateJson(context,from);
        String response = getHttpClient().processor(getAppName(),json);
        return JSONObject.parseObject(response,WeiXinResponse.class);
    }
}
