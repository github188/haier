package com.haier.domain.hp;

/**
 * Created by ehl on 2016/6/5.
 */
public class HPAddWoDataRequestBuilder {

    public static HPAddWoDataRequestBuilder create(){
        return new HPAddWoDataRequestBuilder();
    }

    public  HPAddWoDataRequest build(){
        HPAddWoDataRequest request = new HPAddWoDataRequest();
        request.setAddress(getAddress());
        request.setApply_id(getApply_id());
        request.setArea_code(getArea_code());
        request.setBuy_date(getBuy_date());
        request.setCareer(getCareer());
        request.setCity(getCity());
        request.setClient_type(getClient_type());
        request.setCookie_id(getCookie_id());
        request.setCountry(getCountry());
        request.setCustomer_name(getCustomer_name());
        request.setDistrict(getDistrict());
        request.setEmail(getEmail());
        request.setLogin_username(getLogin_username());
        request.setMobile_phone(getMobile_phone());
        request.setModel_number(getModel_number());
        request.setPhone(getPhone());
        request.setProduct_id(getProduct_id());
        request.setProvince(getProvince());
        request.setRequire_service_date(getRequire_service_date());
        request.setRequire_service_desc(getRequire_service_desc());
        request.setResource_name(getResource_name());
        request.setService_time(getService_time());
        request.setService_type(getService_type());
        request.setSex(getSex());
        request.setSource_code(getSource_code());
        request.setUserip(getUserip());
        return request;
    }



    //Y
    private String apply_id;//对方系统工单ID（不可以重复）
    //Y最小分类
    private String product_id;//产品大类(HP系统产品大类ID rrs.hpbasic.product.getbrandproduct接口的sub_prod_id字段)
    //Y
    private String service_type;//T01-->维修   T02-->安装   T12-->移机
    //N
    private String buy_date;//yyyy-MM-dd
    //Y
    private String require_service_date;// yyyy-MM-dd HH:mm:ss
    //Y
    private String customer_name;//顾客姓名
    //N
    private String sex;
    //N
    private String career;//职业
    //Y
    private String mobile_phone;
    //N
    private String phone;
    //N
    private String area_code;
    //N
    private String country;
    //N
    private String province;
    //N
    private String city;
    //Y
    private String district; //区(6位国标编码 rrs.gis.get.regionNew接口中的admin_code字段)
    //Y
    private String address;//dizhi
    //N
    private String model_number;
    //Y
    private String require_service_desc;
    //Y
    private String service_time;//时间段
    //Y
    private String userip="115.28.231.67";
    //N
    private String login_username;
    //N
    private String email;//
    //N
    private String cookie_id;
    //N
    private String resource_name;
    //N
    private String source_code;
    //N
    private String client_type;


    public String getApply_id() {
        return apply_id;
    }

    public HPAddWoDataRequestBuilder setApply_id(String apply_id) {
        this.apply_id = apply_id;
        return this;
    }

    public String getProduct_id() {
        return product_id;
    }

    public HPAddWoDataRequestBuilder setProduct_id(String product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getService_type() {
        return service_type;
    }

    public HPAddWoDataRequestBuilder setService_type(String service_type) {
        this.service_type = service_type;
        return this;
    }

    public String getBuy_date() {
        return buy_date;
    }

    public HPAddWoDataRequestBuilder setBuy_date(String buy_date) {
        this.buy_date = buy_date;
        return this;
    }

    public String getRequire_service_date() {
        return require_service_date;
    }

    public HPAddWoDataRequestBuilder setRequire_service_date(String require_service_date) {
        this.require_service_date = require_service_date;
        return this;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public HPAddWoDataRequestBuilder setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public HPAddWoDataRequestBuilder setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getCareer() {
        return career;
    }

    public HPAddWoDataRequestBuilder setCareer(String career) {
        this.career = career;
        return this;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public HPAddWoDataRequestBuilder setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public HPAddWoDataRequestBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getArea_code() {
        return area_code;
    }

    public HPAddWoDataRequestBuilder setArea_code(String area_code) {
        this.area_code = area_code;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public HPAddWoDataRequestBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public HPAddWoDataRequestBuilder setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public HPAddWoDataRequestBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public HPAddWoDataRequestBuilder setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public HPAddWoDataRequestBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getModel_number() {
        return model_number;
    }

    public HPAddWoDataRequestBuilder setModel_number(String model_number) {
        this.model_number = model_number;
        return this;
    }

    public String getRequire_service_desc() {
        return require_service_desc;
    }

    public HPAddWoDataRequestBuilder setRequire_service_desc(String require_service_desc) {
        this.require_service_desc = require_service_desc;
        return this;
    }

    public String getService_time() {
        return service_time;
    }

    public HPAddWoDataRequestBuilder setService_time(String service_time) {
        this.service_time = service_time;
        return this;
    }

    public String getUserip() {
        return userip;
    }

    public HPAddWoDataRequestBuilder setUserip(String userip) {
        this.userip = userip;
        return this;
    }

    public String getLogin_username() {
        return login_username;
    }

    public HPAddWoDataRequestBuilder setLogin_username(String login_username) {
        this.login_username = login_username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public HPAddWoDataRequestBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCookie_id() {
        return cookie_id;
    }

    public HPAddWoDataRequestBuilder setCookie_id(String cookie_id) {
        this.cookie_id = cookie_id;
        return this;
    }

    public String getResource_name() {
        return resource_name;
    }

    public HPAddWoDataRequestBuilder setResource_name(String resource_name) {
        this.resource_name = resource_name;
        return this;
    }

    public String getSource_code() {
        return source_code;
    }

    public HPAddWoDataRequestBuilder setSource_code(String source_code) {
        this.source_code = source_code;
        return this;
    }

    public String getClient_type() {
        return client_type;
    }

    public HPAddWoDataRequestBuilder setClient_type(String client_type) {
        this.client_type = client_type;
        return this;
    }
}
