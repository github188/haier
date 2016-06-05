package com.haier.controller.api;

import com.haier.common.exception.ApiException;
import com.haier.common.response.ResponseBody;
import com.haier.common.response.ResponseConstantCode;
import com.haier.common.response.ResponseMsg;
import com.haier.controller.BaseController;
import com.haier.service.CommonService;
import com.haier.domain.Brand;
import com.haier.domain.ProductSubType;
import com.haier.domain.ProductType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
@Controller
@RequestMapping("/test/1.0/common")
public class CommonController extends BaseController {
    Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private CommonService commonService;

    @RequestMapping(path="/getBrandList",method= RequestMethod.GET)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody getBrandList(){
        log.debug("===========getBrandList receive Message=======");
        ResponseMsg messsage = new ResponseMsg();
        try{
            List<Brand> brandList = commonService.getBrandList();
            messsage.setCode(ResponseConstantCode.SUCCESS_CODE);
            messsage.setMessage(ResponseConstantCode.SUCCESS_DESC);
            messsage.setInfo(brandList);
        }catch(Exception ex){
            log.error(ex.getMessage());
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ResponseConstantCode.INTERNAL_ERROR_DESC);
        }

        return messsage;
    }
    @RequestMapping(path="/getTypeList/{brandCode}",method= RequestMethod.GET)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody getTypeList(@PathVariable String brandCode){
        log.debug("===========getTypeList receive Message======= | brandCode :"+brandCode);
        ResponseMsg messsage = new ResponseMsg();
        try{
            List<ProductType> typeList = commonService.getProductTypeList(brandCode);
            messsage.setCode(ResponseConstantCode.SUCCESS_CODE);
            messsage.setMessage(ResponseConstantCode.SUCCESS_DESC);
            messsage.setInfo(typeList);
        }catch(Exception ex){
            log.error(ex.getMessage());
            if(ex instanceof ApiException){
                ApiException apiException = (ApiException)ex;
                return new ResponseMsg(apiException.getCode(),apiException.getMessage());
            }
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ResponseConstantCode.INTERNAL_ERROR_DESC);
        }
        return messsage;
    }

    @RequestMapping(path="/getSubTypeList/{typeCode}",method= RequestMethod.GET)
    @org.springframework.web.bind.annotation.ResponseBody
    public ResponseBody getSubTypeList(@PathVariable String typeCode){
        log.debug("===========getTypeList receive Message======= | typeCode :"+typeCode);
        ResponseMsg messsage = new ResponseMsg();
        try{
            List<ProductSubType> subTypeList = commonService.getProductSubTypeList(typeCode);
            messsage.setCode(ResponseConstantCode.SUCCESS_CODE);
            messsage.setMessage(ResponseConstantCode.SUCCESS_DESC);
            messsage.setInfo(subTypeList);
        }catch(Exception ex){
            log.error(ex.getMessage());
            if(ex instanceof ApiException){
                ApiException apiException = (ApiException)ex;
                return new ResponseMsg(apiException.getCode(),apiException.getMessage());
            }
            return new ResponseMsg(ResponseConstantCode.INTERNAL_ERROR_CODE,ResponseConstantCode.INTERNAL_ERROR_DESC);
        }
        return messsage;
    }

}
