package com.haier.qrcode.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Administrator on 2016/6/9.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultMessage", propOrder = { "msgCode", "msgContent", "msgTime"})
public class ResultMessage {
    @XmlElement(name="MsgCode",required = true)
    private String msgCode;
    @XmlElement(name="MsgContent",required = true)
    private String msgContent;
    @XmlElement(name="MsgTime",required = true)
    private String msgTime;

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("MsgInfo :[");
        sb.append("msgCode:"+msgCode+";");
        sb.append("msgContent:"+msgContent+";");
        sb.append("msgTime:"+msgTime+"]");
        return sb.toString();
    }
}
