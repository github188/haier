package com.haier.hp.service;

import com.haier.hp.domain.HPAddWoDataRequest;
import com.haier.hp.domain.HPAddWoDataResponse;
import com.haier.hp.domain.HPWoListResponse;
import com.haier.hp.domain.HPWoWholeInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by ehl on 2016/6/5.
 */
public interface HPFacade {
    /**
     * 4.1.1报装报修数据提交接口
     * 提报报装报修数据(source_code本次固定传)
     * 请求method	rrs.order.addwodata
     入参
     名称	是否必填	名称

     apply_id	Y	对方系统工单ID（不可以重复）
     product_id	Y	产品大类(HP系统产品大类ID rrs.hpbasic.product.getbrandproduct接口的sub_prod_id字段)
     service_type	Y	要求服务类型(HP系统服务类型CODE rrs.hcsp.st.getStList接口的service_type_code字段)
     buy_date	N	购买日期 yyyy-MM-dd
     require_service_date	Y	要求服务时间 yyyy-MM-dd HH:mm:ss（要晚于当前时间）
     customer_name	Y	用户姓名
     sex	N	性别
     career	N	职业
     mobile_phone	Y	手机号码
     phone	N	电话号码
     area_code	N	区号
     country	N	国家（描述）
     province	N	省（描述）
     city	N	市（描述）
     district	Y	区(6位国标编码 rrs.gis.get.regionNew接口中的admin_code字段)
     address	Y	客户地址（为省市区+详细地址）
     model_number	N	产品型号（最长16位）
     require_service_desc	Y	要求服务描述
     service_time	Y	服务时间段
     userip	Y	用户ip
     login_username	N	用户登录名
     email	N	邮箱
     cookie_id	N	第三方提供，用于虚假提交校验
     resource_name	N	来源名称
     source_code	N	订单来源编号（本次传定值）
     client_type	N	客户端类型（0-电脑 1-手机/PAD）最大长度1     V2.8新增

     出参
     名称	类型	名称
     data	String	data


     4.1.1.3返回信息
     {"status":"ok","code":"200","msg":"操作成功","data":"ORD010HJ86BZX604"}
     * @param addWoDataRequest
     * @return
     * @throws Exception
     */
    public HPAddWoDataResponse executeAddWoData(HPAddWoDataRequest addWoDataRequest) throws Exception;


    public HPAddWoDataResponse executeAddWoData(Map<String, Object> params) throws Exception;

    HPWoListResponse executeWoList(String phone,String flag)throws Exception;

    HPWoListResponse executeWoList(String phone)throws Exception;

    HPWoWholeInfo executeWoWholeInfo(String orderId) throws  Exception;

 /**
  * ,隔开
  * @param orderId
  * @return
  * @throws Exception
  */
    List<HPWoWholeInfo> executeWoWholeInfoBatch(String orderId) throws  Exception;


}
