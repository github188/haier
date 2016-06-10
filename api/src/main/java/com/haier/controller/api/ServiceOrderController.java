package com.haier.controller.api;

import com.haier.common.ApplyIdGenerate;
import com.haier.common.response.ResponseBody;
import com.haier.common.response.ResponseConstantCode;
import com.haier.common.response.ResponseMsg;
import com.haier.controller.BaseController;
import com.haier.domain.ServiceOrder;
import com.haier.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bright on 16-6-5.
 */
@Controller
@RequestMapping("/haier/1.0/order")
public class ServiceOrderController extends BaseController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;

    @RequestMapping(path = "/newOrder",method = RequestMethod.POST)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody newOrder(@RequestBody ServiceOrder serviceOrder){
        serviceOrder.setApply_id(ApplyIdGenerate.getDefaultApplyId());
        if(serviceOrder.check()){
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
//        serviceOrder.setApply_id("leixwksdjaflsd");
//        serviceOrder.setProduct_id("16");
//        serviceOrder.setService_type("T01");
//        serviceOrder.setRequire_time(new Date());
//        serviceOrder.setCotact_name("雷晓武");
//        serviceOrder.setMobile_phone("15022086097");
//        serviceOrder.setDistrict("120103");
//        serviceOrder.setService_address("天津市河西区福建路4号");
//        serviceOrder.setRequire_service_desc("安装");
//        serviceOrder.setOrder_time(new Date());
//        serviceOrder.setService_time("2016-06-05 17:00:00-2016-06-05 17:00:00");
        try{
            orderService.saveOrder(serviceOrder);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE, ex.getMessage());
        }
        return getSuccess();
    }
}
