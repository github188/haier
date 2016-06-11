package com.haier.hp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.haier.common.ObjectUtils;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.hp.domain.HPAddWoDataRequest;
import com.haier.hp.domain.HPAddWoDataResponse;
import com.haier.hp.domain.HPWoListResponse;
import com.haier.hp.domain.HPWoWholeInfo;
import com.haier.hp.service.AbstractHpSys;
import com.haier.hp.service.HPFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
@Service
public class HpFacadeImpl extends AbstractHpSys implements HPFacade {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public HPAddWoDataResponse executeAddWoData(HPAddWoDataRequest addWoDataRequest) throws Exception {
        logger.info(addWoDataRequest.toString());
         return executeAddWoData(ObjectUtils.toMap(addWoDataRequest));
    }

    @Override
    public HPAddWoDataResponse executeAddWoData(Map<String, Object> params) throws Exception {

        String url = getHpUrl();
        Map<String,Object> req=getAddWoDataParams(params);

        String json= HEHttpClients.httpGetExecute(url,req);
        logger.info("request hp result:"+json);
        if(Strings.isNullOrEmpty(json)){
            throw new Exception("return null");
        }
        return JSONObject.parseObject(json, HPAddWoDataResponse.class);
    }

    @Override
    public HPWoListResponse executeWoList(String phone, String flag) throws Exception {
        if(Strings.isNullOrEmpty(phone) || Strings.isNullOrEmpty(flag)){
            throw new Exception("null parameter with phone or flag");
        }
        Map<String,Object> maps = Maps.newHashMap();
        maps.put("phone",phone);
        maps.put("flag", flag);
        Map<String,Object> req=getWoList(maps);
        logger.error(getHpUrl());
        String response= HEHttpClients.httpGetExecute(getHpUrl(),req);
        logger.error(response);
        return JSONObject.parseObject(response, HPWoListResponse.class);
    }

    @Override
    public HPWoListResponse executeWoList(String phone) throws Exception {
        return executeWoList(phone,"1");
    }

    @Override
    public HPWoWholeInfo executeWoWholeInfo(String orderId) throws Exception {
        return null;
    }

    @Override
    public List<HPWoWholeInfo> executeWoWholeInfoBatch(String orderId) throws Exception {
        return null;
    }


}
