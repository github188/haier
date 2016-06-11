package com.haier.weixin.service;

import com.haier.weixin.domain.WeiXinResponse;

/**
 * Created by ehl on 2016/6/11.
 */
public interface WeiXinFacade {
    /**
     * 关注
     * @return
     * @throws Exception
     */
    public WeiXinResponse subscribe(String context,String from)throws Exception;

    /**
     * 注册
     * @return
     * @throws Exception
     */
    public WeiXinResponse userRegister(String context,String from)throws Exception;

    /**
     * 验证码,激活
     * @return
     * @throws Exception
     */
    public WeiXinResponse userActivate(String context,String from)throws Exception;

}
