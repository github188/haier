package com.haier.service;

import com.haier.qrcode.domain.GetOIDProductInfoOutput;

/**
 * Created by Administrator on 2016/6/9.
 */
public interface QRService {
   public GetOIDProductInfoOutput getOIDProductInfo(String oidContent) throws Exception;
}
