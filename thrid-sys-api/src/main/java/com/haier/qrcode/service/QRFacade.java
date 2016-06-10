package com.haier.qrcode.service;

import com.haier.qrcode.domain.GetOIDProductInfoInput;
import com.haier.qrcode.domain.GetOIDProductInfoOutput;

/**
 * Created by Administrator on 2016/6/9.
 */
public interface QRFacade {
    public GetOIDProductInfoOutput getOIDProductInfo(GetOIDProductInfoInput input) throws Exception;
}
