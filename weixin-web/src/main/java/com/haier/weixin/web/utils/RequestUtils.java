package com.haier.weixin.web.utils;

import com.google.common.collect.Maps;
import com.haier.weixin.web.domain.ServiceOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

/**
 * Created by ehl on 2016/6/5.
 */
public class RequestUtils {
    private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);
    public static Map<String,String> matchParameterWithOrder(HttpServletRequest request) throws Exception {
        Map<String,String> parameters=request.getParameterMap();
        ServiceOrder order = new ServiceOrder();
        Set<String> keys = ObjectUtils.toMap(order).keySet();
        Map<String,String> maps = Maps.newHashMap();
        for(String key:keys){
            if(parameters.containsKey(key)){
                maps.put(key,parameters.get(key));
            }
        }

        ObjectUtils.toObj(maps,order);
        if(order.check()){
            throw new NullPointerException("parameter is null");
        }
        return maps;
    }
}
