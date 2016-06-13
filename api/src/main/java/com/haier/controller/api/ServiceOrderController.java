package com.haier.controller.api;

import com.google.common.base.Strings;
import com.haier.common.ApplyIdGenerate;
import com.haier.common.response.*;
import com.haier.controller.BaseController;
import com.haier.domain.ServiceOrder;
import com.haier.domain.ServiceOrderTrace;
import com.haier.hp.domain.HPWoListData;
import com.haier.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

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
//        serviceOrder.setProduct_id("16");
//        serviceOrder.setService_type("T01");
//        serviceOrder.setRequire_service_date(new Date());
//        serviceOrder.setContact_name("雷晓武");
//        serviceOrder.setMobile_phone("15022086097");
//        serviceOrder.setDistrict("120103");
//        serviceOrder.setAddress("天津市河西区福建路4号");
//        serviceOrder.setRequire_service_desc("安装");
//        serviceOrder.setOrder_time(new Date());
//        serviceOrder.setService_time("2016-06-05 17:00:00-2016-06-05 17:00:00");
        if(serviceOrder.getUser_id()==0){
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE,"parameter user_id not found");
        }
        if(serviceOrder.check()){
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }

        try{
            orderService.saveOrder(serviceOrder);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE, ex.getMessage());
        }
        return getSuccess();
    }
    @RequestMapping(path = "/getOrderList",method = RequestMethod.POST)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody getOrderList(@RequestBody ServiceOrderPage page){
        if(page.getUser_id() == 0 || Strings.isNullOrEmpty(page.getStatus())
                || page.getPageNumber() == 0 || page.getPageSize() == 0){
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
        try {
            page = orderService.getOrderListPage(page);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE, e.getMessage());
        }
        page.setCode(ResponseConstantCode.SUCCESS_CODE);
        page.setMessage(ResponseConstantCode.SUCCESS_DESC);
        return page;
    }

    @RequestMapping(path = "/getOrderTrack/{orderCode}",method = RequestMethod.GET)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody getOrderTrack(@PathVariable String orderCode){
        if(Strings.isNullOrEmpty(orderCode)){
            return new ResponseMsg(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
        List<ServiceOrderTrace> list = null;
        try {
           list= orderService.getServiceOrderTrack(orderCode);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE, e.getMessage());
        }
        ResponseMsg msg = new ResponseMsg(ResponseConstantCode.SUCCESS_CODE,ResponseConstantCode.SUCCESS_DESC);
        msg.setInfo(list);
        return msg;
    }
}
