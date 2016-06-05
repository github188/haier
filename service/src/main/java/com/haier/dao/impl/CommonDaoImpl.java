package com.haier.dao.impl;

import com.haier.dao.CommonDao;
import com.haier.domain.Brand;
import com.haier.domain.ProductSubType;
import com.haier.domain.ProductType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bright on 16-6-5.
 */
@Transactional(readOnly = true)
@Repository("")
public class CommonDaoImpl extends BaseDaoImpl implements CommonDao {
    @Override
    public List<Brand> getBrandList() throws Exception{
            StringBuilder sql = new StringBuilder("select code,name from t_product_brand");
            List<Brand> list =  super.getBySqlRowMapper(sql.toString(), new RowMapper<Brand>() {
                @Override
                public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
                    Brand brand = new Brand();
                    brand.setCode(resultSet.getString("code"));
                    brand.setName(resultSet.getString("name"));
                    return brand;
                }
            });
            return list;
    }

    @Override
    public List<ProductType> getProductTypeList(String brandCode) throws Exception{
            StringBuilder sql = new StringBuilder("select code,name from t_product_category where brand_code='");
            sql.append(brandCode);
            sql.append("'");
            List<ProductType> list =  super.getBySqlRowMapper(sql.toString(), new RowMapper<ProductType>() {
                @Override
                public ProductType mapRow(ResultSet resultSet, int i) throws SQLException {
                    ProductType type = new ProductType();
                    type.setCode(resultSet.getString("code"));
                    type.setName(resultSet.getString("name"));
                    return type;
                }
            });
            return list;
    }

    @Override
    public List<ProductSubType> getProductSubTypeList(String typeCode)  throws Exception{
            StringBuilder sql = new StringBuilder("select code,name from t_product_subcategory where category_code='");
            sql.append(typeCode);
            sql.append("'");
            List<ProductSubType> list =  super.getBySqlRowMapper(sql.toString(), new RowMapper<ProductSubType>() {
                @Override
                public ProductSubType mapRow(ResultSet resultSet, int i) throws SQLException {
                    ProductSubType subType = new ProductSubType();
                    subType.setCode(resultSet.getString("code"));
                    subType.setName(resultSet.getString("name"));
                    return subType;
                }
            });
            return list;
    }
}
