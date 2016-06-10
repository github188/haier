package com.haier.hp.service;

import com.google.common.collect.Maps;
import com.haier.ThridSysConfig;

import java.util.Date;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */

public abstract class AbstractHpSys extends ThridSysConfig {

    /**
     * 提交订单
     * @return
     */
    protected Map<String,Object> getAddWoDataParams(Map<String,Object> otherParameter){
        Map<String,Object> params=getHpDefaultParams();
        params.put("method","rrs.order.addwodata");
        if(null == otherParameter || otherParameter.isEmpty()){
            return params;
        }
        params.putAll(otherParameter);
        return params;
    }
//    protected get
    /**
     * 订单列表
     * @return
     */
    protected Map<String,Object> getWoList(Map<String,Object> otherParameter){
        Map<String,Object> params=getHpDefaultParams();
        params.put("method","rrs.hcsp.wo.getwolist");
        if(null == otherParameter || otherParameter.isEmpty()){
            return params;
        }
        params.putAll(otherParameter);
        return params;
    }

    /**
     * 默认参数
     * @return
     */
    private  Map<String,Object> getHpDefaultParams(){
        Map<String,Object> params = Maps.newHashMap();
        params.put("timestamp",new Date().getTime()+"");
        params.put("access_token",getHpToken());
        return params;
    }
}
