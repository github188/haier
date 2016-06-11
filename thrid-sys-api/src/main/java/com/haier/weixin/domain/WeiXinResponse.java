package com.haier.weixin.domain;

/**
 * Created by ehl on 2016/6/11.
 * {"body":
 * {"content":"您已注册海尔会员。登录vip.haier.com互动赢好礼，完善信息或修改密码，还能尊享免费家电保养、精彩会员活动，电子杂志等会员权益","msgType":"text"},
 * "isAskNextRequest":"false",
 * "action":"termination",
 * "url":"http://tuser.haier.com/ids/service?idsServiceType=wxService&type=HaierWeixinAction&action=termination&appWeixinID=gh_620462d9b1ad"
 * }

 */
public class WeiXinResponse {
    private String isAskNextRequest;
    private String action;
    private String url;
    private WeiXinResponseBody body;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeiXinResponse{");
        sb.append("isAskNextRequest='").append(isAskNextRequest).append('\'');
        sb.append(", action='").append(action).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", body=").append(body);
        sb.append('}');
        return sb.toString();
    }

    public String getIsAskNextRequest() {
        return isAskNextRequest;
    }

    public void setIsAskNextRequest(String isAskNextRequest) {
        this.isAskNextRequest = isAskNextRequest;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WeiXinResponseBody getBody() {
        return body;
    }

    public void setBody(WeiXinResponseBody body) {
        this.body = body;
    }
}
