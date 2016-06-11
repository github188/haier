package com.haier.domain;

import com.google.common.base.Strings;

import java.util.Date;

/**
 * Created by bright on 16-6-11.
 */
public class UserProduct {
    private int id;
    private int userId;
    private String brand;
    private String category;
    private String subCategory;
    private String type;
    private String productCode;
    private Date purchaseDate;
    private int guaranteeYear;
    private String serviceAddress;
    private Date updatetime = new Date();


    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getGuaranteeYear() {
        return guaranteeYear;
    }

    public void setGuaranteeYear(int guaranteeYear) {
        this.guaranteeYear = guaranteeYear;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    @Override
    public String toString() {
        return "UserProduct{" +
                "id=" + id +
                ", userId=" + userId +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", type='" + type + '\'' +
                ", productCode='" + productCode + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", guaranteeYear=" + guaranteeYear +
                ", serviceAddress='" + serviceAddress + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }

    public boolean check(){
        return userId==0 || Strings.isNullOrEmpty(brand) || Strings.isNullOrEmpty(category)
                || Strings.isNullOrEmpty(subCategory) || Strings.isNullOrEmpty(type)
                ||Strings.isNullOrEmpty(productCode) || purchaseDate == null
                ||guaranteeYear==0|| Strings.isNullOrEmpty(serviceAddress);
    }
}
