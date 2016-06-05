package com.haier.controller.api;

import com.alibaba.fastjson.serializer.NameFilter;
import com.haier.common.ResponseBody;
import com.haier.common.ResponseConstantCode;
import com.haier.common.ResponseMsg;
import com.haier.controller.BaseController;
import com.haier.test.TestService;
import com.haier.vo.InstallOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
@Controller
@RequestMapping("/test/1.0/install")
public class InstallController extends BaseController {

    Logger log = LoggerFactory.getLogger(InstallController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("/newOrder")
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody newOrder(InstallOrder installOrder){
        try{
            testService.save();
        }catch(Exception ex){
            log.error(ex.getMessage());
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ResponseConstantCode.SUCCESS_DESC);
        }
        return getSuccess();
    }
    @RequestMapping("/newRemoveOrder")
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody newRemoveOrder(){

        testService.save();

        return getSuccess();
    }
}
