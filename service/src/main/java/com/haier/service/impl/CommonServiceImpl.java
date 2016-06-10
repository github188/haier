package com.haier.service.impl;

import com.google.common.base.Strings;
import com.haier.common.exception.ApiException;
import com.haier.common.response.ResponseConstantCode;
import com.haier.dao.CommonDao;
import com.haier.service.CommonService;
import com.haier.domain.Brand;
import com.haier.domain.ProductSubType;
import com.haier.domain.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService{

    @Autowired
    private CommonDao commonDao;


    @Override
    public List<Brand> getBrandList() throws Exception{
        return commonDao.getBrandList();
    }

    @Override
    public List<ProductType> getProductTypeList(String brandCode) throws Exception {
        if(Strings.isNullOrEmpty(brandCode)){
            throw new ApiException(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
        return commonDao.getProductTypeList(brandCode);
    }

    @Override
    public List<ProductSubType> getProductSubTypeList(String typeCode) throws Exception {
        if(Strings.isNullOrEmpty(typeCode)){
            throw new ApiException(ResponseConstantCode.INVALID_PARAMETER_CODE,ResponseConstantCode.INVALID_PARAMETER_DESC);
        }
        return commonDao.getProductSubTypeList(typeCode);
    }
}
