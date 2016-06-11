package com.haier.weixin.domain;

/**
 * Created by ehl on 2016/6/11.
 * "{'action':'userActivate',
 * 'body':{'content':'564301','fromUserName':'dsfd','msgType':'text','toUserName':'gh_620462d9b1ad'}}";
 */
public class WeiXinRequest {
    private String action="";
    private WeiXinRequestBody body;

    public WeiXinRequest(String action) {
        this.action = action;
    }

    public WeiXinRequest(String action, WeiXinRequestBody body) {
        this.action = action;
        this.body = body;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeiXinRequest{");
        sb.append("action='").append(action).append('\'');
        sb.append(", body=").append(body);
        sb.append('}');
        return sb.toString();
    }

    public void setAction(String action) {
        this.action = action;
    }

    public WeiXinRequestBody getBody() {
        return body;
    }

    public void setBody(WeiXinRequestBody body) {
        this.body = body;
    }
}
