package com.haier.service;

import com.haier.qrcode.domain.getOIDProductInfoOutput;

/**
 * Created by Administrator on 2016/6/9.
 */
public interface QRService {
   public getOIDProductInfoOutput getOIDProductInfo(String oidContent) throws Exception;
}
