package com.haier.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.haier.dao.UserDao;
import com.haier.domain.Area;
import com.haier.domain.City;
import com.haier.domain.Province;
import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ehl on 2016/6/4.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserDao userDao;


    @Override
    public void save() {
        List<Test> list = userDao.test();
        if(null == list ){
            System.out.print("null");
        }
        else {
            System.out.println(list.size());
        }
    }

    @Override
    public void readCityJson() {
        List<HashMap<String,String>> provinceList = userDao.findProvince();
        List<HashMap<String,String>> cityList = userDao.findCity();
        List<HashMap<String,String>> regionList = userDao.findRegion();
        List<Province> list = Lists.newArrayList();
        for(HashMap<String,String> map:provinceList){
            Province province = new Province();
            province.setCode(map.get("pro_code"));
            province.setName(map.get("province"));
            List<City> cityList1 = Lists.newArrayList();
            for(HashMap<String,String> map1:cityList){
                if(map1.get("pro_code").equals(province.getCode())){
                    City city = new City();
                    city.setCode(map1.get("city_code"));
                    city.setName(map1.get("city"));
                    List<Area> areas = Lists.newArrayList();
                    for(HashMap<String,String> map2:regionList){
                        Area area = new Area();
                        if(map2.get("city_code").equals(city.getCode())){
                            area.setCode(map2.get("admin_code"));
                            area.setName(map2.get("region_name"));
                            areas.add(area);
                        }
                    }
                    city.setSub(areas);
                    cityList1.add(city);
                }
            }
            province.setSub(cityList1);
            list.add(province);
        }
        System.out.println(JSON.toJSONString(list,true));
    }
}
