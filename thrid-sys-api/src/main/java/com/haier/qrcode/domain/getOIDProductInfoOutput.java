package com.haier.qrcode.domain;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 2016/6/9.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
@XmlType(propOrder = {"resultMessage","productInfo"})
public class GetOIDProductInfoOutput {
    @XmlElement(name="ResultMessage",required = true)
    private ResultMessage resultMessage;

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public ResultMessage getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(ResultMessage resultMessage) {
        this.resultMessage = resultMessage;
    }

    @XmlElement(name="ProductInfo",required = true)
    private ProductInfo productInfo;

    @Override
    public String toString(){
        return resultMessage.toString()+"\n"+productInfo.toString();
    }

}
