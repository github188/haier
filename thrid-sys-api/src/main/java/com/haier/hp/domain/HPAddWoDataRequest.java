package com.haier.hp.domain;

/**
 * Created by ehl on 2016/6/5.
 */
public class HPAddWoDataRequest {
    //Y
    private String apply_id="";//对方系统工单ID（不可以重复）
    //Y最小分类
    private String product_id="";//产品大类(HP系统产品大类ID rrs.hpbasic.product.getbrandproduct接口的sub_prod_id字段)
    //Y
    private String service_type="";//T01-->维修   T02-->安装   T12-->移机
    //N
    private String buy_date="";//yyyy-MM-dd
    //Y
    private String require_service_date="";// yyyy-MM-dd HH:mm:ss
    //Y
    private String customer_name="";//顾客姓名
    //N
    private String sex="";
    //N
    private String career="";//职业
    //Y
    private String mobile_phone="";
    //N
    private String phone="";
    //N
    private String area_code="";
    //N
    private String country="";
    //N
    private String province="";
    //N
    private String city="";
    //Y
    private String district=""; //区(6位国标编码 rrs.gis.get.regionNew接口中的admin_code字段)
    //Y
    private String address="";//dizhi
    //N
    private String model_number="";
    //Y
    private String require_service_desc="";
    //Y
    private String service_time="";//时间段
    //Y
    private String userip="115.28.231.67";
    //N
    private String login_username="";
    //N
    private String email="";//
    //N
    private String cookie_id="";
    //N
    private String resource_name="";
    //N
    private String source_code="";
    //N
    private String client_type="";

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }

    public String getRequire_service_date() {
        return require_service_date;
    }

    public void setRequire_service_date(String require_service_date) {
        this.require_service_date = require_service_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModel_number() {
        return model_number;
    }

    public void setModel_number(String model_number) {
        this.model_number = model_number;
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

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public String getLogin_username() {
        return login_username;
    }

    public void setLogin_username(String login_username) {
        this.login_username = login_username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCookie_id() {
        return cookie_id;
    }

    public void setCookie_id(String cookie_id) {
        this.cookie_id = cookie_id;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HPAddWoDataRequest{");
        sb.append("apply_id='").append(apply_id).append('\'');
        sb.append(", product_id='").append(product_id).append('\'');
        sb.append(", service_type='").append(service_type).append('\'');
        sb.append(", buy_date='").append(buy_date).append('\'');
        sb.append(", require_service_date='").append(require_service_date).append('\'');
        sb.append(", customer_name='").append(customer_name).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", career='").append(career).append('\'');
        sb.append(", mobile_phone='").append(mobile_phone).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", area_code='").append(area_code).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", model_number='").append(model_number).append('\'');
        sb.append(", require_service_desc='").append(require_service_desc).append('\'');
        sb.append(", service_time='").append(service_time).append('\'');
        sb.append(", userip='").append(userip).append('\'');
        sb.append(", login_username='").append(login_username).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", cookie_id='").append(cookie_id).append('\'');
        sb.append(", resource_name='").append(resource_name).append('\'');
        sb.append(", source_code='").append(source_code).append('\'');
        sb.append(", client_type='").append(client_type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
