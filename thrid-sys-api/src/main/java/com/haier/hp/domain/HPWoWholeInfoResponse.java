package com.haier.hp.domain;

/**
 * Created by bright on 16-6-11.
 */
public class HPWoWholeInfoResponse {
    private String code;
    private String status;
    private String msg;


    public HPWoWholeInfo getData() {
        return data;
    }

    public void setData(HPWoWholeInfo data) {
        this.data = data;
    }

    private HPWoWholeInfo data;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
