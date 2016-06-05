package com.haier.common;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
public class ObjectUtils {
    /**
     *
     * @param object
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Map<String,String> toMap(Object object) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return BeanUtils.describe(object);
    }

    /**
     *
     * @param maps
     * @param obj
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void toObj(Map<String,String> maps,Object obj) throws InvocationTargetException, IllegalAccessException {
        if(null == maps || maps.size()==0){
            return;
        }
        BeanUtils.populate(obj,maps);
    }
}
