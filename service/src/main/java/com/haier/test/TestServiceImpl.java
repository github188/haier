package com.haier.test;

import com.haier.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
