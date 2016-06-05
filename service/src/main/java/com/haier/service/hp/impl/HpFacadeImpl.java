package com.haier.service.hp.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.haier.common.ObjectUtils;
import com.haier.common.httpclient.HEHttpClients;
import com.haier.domain.hp.HPAddWoDataRequest;
import com.haier.domain.hp.HPAddWoDataResponse;
import com.haier.service.hp.AbstractHpSys;
import com.haier.service.hp.HPFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
    public HPAddWoDataResponse executeAddWoData(Map<String, String> params) throws Exception {
        String url = getHpUrl();
        Map<String,String> req=getAddWoDataParams();
        req.putAll(params);
        logger.info(req.size()+"\t"+req.get("timestamp"));
        String json= HEHttpClients.httpGetExecute(url,req);
        if(Strings.isNullOrEmpty(json)){
            throw new Exception("return null");
        }
        return JSONObject.parseObject(json, HPAddWoDataResponse.class);
    }
}
