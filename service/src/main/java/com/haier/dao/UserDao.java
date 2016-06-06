package com.haier.dao;

import com.haier.test.Test;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    public List<Test> test();

    public List<HashMap<String,String>> findCity();

    public List<HashMap<String,String>> findProvince();

    public List<HashMap<String,String>> findRegion();
}
