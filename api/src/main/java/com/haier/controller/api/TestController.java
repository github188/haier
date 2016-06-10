package com.haier.controller.api;

import com.haier.common.response.ResponseBody;
import com.haier.controller.BaseController;
import com.haier.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ehl on 2016/6/4.
 */
@Controller
@RequestMapping("/test/1.0/*")
public class TestController  extends BaseController{
    @Autowired
    private TestService testService;
    @RequestMapping("/example")
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody getTest(){

        testService.save();

        return getSuccess();
    }
}
