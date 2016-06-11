package com.haier.weixin.domain;

/**
 * Created by ehl on 2016/6/11.
 */
public class WeiXinResponseBody {
    private String content;
    private String msgType;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeiXinResponseBody{");
        sb.append("content='").append(content).append('\'');
        sb.append(", msgType='").append(msgType).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
