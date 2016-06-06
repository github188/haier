package com.haier.weixin.web.domain;


import com.google.common.base.Strings;

import java.util.Date;

/**
 * Created by bright on 16-6-5.
 */
public class ServiceOrder {
    private int id;
    private String apply_id;
    private String order_code;
    private String product_id;
    private String user_id;
    private String service_type;
    private Date require_service_date;
    private Date order_time=new Date();
    private String arrive_time="";
    private String service_man_id="-1";
    private String contact_name;
    private String mobile_phone;
    private String district;
    private String address;
    private String require_service_desc;
    private String service_time;
    public boolean check(){
        return Strings.isNullOrEmpty(getProduct_id()) || Strings.isNullOrEmpty(getService_type())
                ||null == getRequire_service_date() || Strings.isNullOrEmpty(getContact_name())
                || Strings.isNullOrEmpty(getMobile_phone())||Strings.isNullOrEmpty(getDistrict())
                || Strings.isNullOrEmpty(getAddress()) || Strings.isNullOrEmpty(getRequire_service_desc())
                ||Strings.isNullOrEmpty(getService_time());
    }
    public ServiceOrder(){
        this.user_id = "0";
    }
    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
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

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public Date getRequire_service_date() {
        return require_service_date;
    }

    public void setRequire_service_date(Date require_service_date) {
        this.require_service_date = require_service_date;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getService_man_id() {
        return service_man_id;
    }

    public void setService_man_id(String service_man_id) {
        this.service_man_id = service_man_id;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRequire_service_desc() {
        return require_service_desc;
    }

    public void setRequire_service_desc(String require_service_desc) {
        this.require_service_desc = require_service_desc;
    }

    public String getService_time() {
        return service_time;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    private Date updatetime=new Date();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ServiceOrder{");
        sb.append("id=").append(id);
        sb.append(", apply_id='").append(apply_id).append('\'');
        sb.append(", order_code='").append(order_code).append('\'');
        sb.append(", product_id='").append(product_id).append('\'');
        sb.append(", user_id='").append(user_id).append('\'');
        sb.append(", service_type='").append(service_type).append('\'');
        sb.append(", require_service_date=").append(require_service_date);
        sb.append(", order_time=").append(order_time);
        sb.append(", arrive_time='").append(arrive_time).append('\'');
        sb.append(", service_man_id='").append(service_man_id).append('\'');
        sb.append(", contact_name='").append(contact_name).append('\'');
        sb.append(", mobile_phone='").append(mobile_phone).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", require_service_desc='").append(require_service_desc).append('\'');
        sb.append(", service_time='").append(service_time).append('\'');
        sb.append(", updatetime=").append(updatetime);
        sb.append('}');
        return sb.toString();
    }
}
