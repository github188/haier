package com.haier.weixin.domain;

/**
 * Created by ehl on 2016/6/11.
 */
public class WeiXinRequestBody {
    private String content;
    private String fromUserName;
    private String msgType="text";
    private String toUserName="gh_620462d9b1ad";

    public WeiXinRequestBody(String content, String fromUserName) {
        this.content = content;
        this.fromUserName = fromUserName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeiXinRequestBody{");
        sb.append("content='").append(content).append('\'');
        sb.append(", fromUserName='").append(fromUserName).append('\'');
        sb.append(", msgType='").append(msgType).append('\'');
        sb.append(", toUserName='").append(toUserName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
}
