package com.haier.service.hp;

import com.google.common.collect.Maps;
import com.haier.service.ThridSysConfig;

import java.util.Date;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
public class AbstractHpSys extends ThridSysConfig {
    protected String getUrlPrefix=getHpUrl();

    protected Map<String,Object> getAddWoDataParams(){
        Map<String,Object> params=getHpDefaultParams();
        params.put("method","rrs.order.addwodata");
        return params;

    }

    protected Map<String,Object> getHpDefaultParams(){
        Map<String,Object> params = Maps.newHashMap();
        params.put("timestamp",new Date().getTime()+"");
        params.put("access_token",getHpToken());
        return params;
    }
}
