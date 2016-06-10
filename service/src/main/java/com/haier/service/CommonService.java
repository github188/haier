package com.haier.service;

import com.haier.domain.Brand;
import com.haier.domain.ProductSubType;
import com.haier.domain.ProductType;

import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
public interface CommonService{

    public List<Brand> getBrandList() throws Exception;

    public List<ProductType> getProductTypeList(String brandCode) throws Exception;

    public List<ProductSubType> getProductSubTypeList(String typeCode) throws Exception;
}
