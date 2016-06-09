package com.haier.qrcode.domain;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 2016/6/9.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductInfo", propOrder = { "brand", "productClass", "type", "barCode" })
public class ProductInfo {
    //产品品牌
    @XmlElement(name = "Brand",required = true)
    private String brand;
    //产品类型（包含大小类）
    @XmlElement(name = "Class",required = true)
    private String productClass;
    //产品型号
    @XmlElement(name = "Type",required = true)
    private String type;

    //产品20位一维条码（注：该节点有两个条码时是用“，”隔开）\
    @XmlElement(name = "BarCode",required = true)
    private String barCode;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ProductInfo:[");
        sb.append("brand:"+brand+",");
        sb.append("productClass:"+productClass+",");
        sb.append("type:"+type+",");
        sb.append("braCode:"+barCode+"]");
        return sb.toString();
    }
}
