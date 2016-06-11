package com.haier.hp.domain;

import java.util.List;

/**
 * Created by ehl on 2016/6/9.
 */
public class HPWoListResponse {
    private String code;
    private String status;
    private String msg;
    private List<HPWoListData> data;
    private int total_result;
    private int page_now;
    private int pagesize;
    private int total_pages;

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

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

    public List<HPWoListData> getData() {
        return data;
    }

    public void setData(List<HPWoListData> data) {
        this.data = data;
    }

    public int getTotal_result() {
        return total_result;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }

    public int getPage_now() {
        return page_now;
    }

    public void setPage_now(int page_now) {
        this.page_now = page_now;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    @Override
    public String toString() {
        return "HPWoListResponse{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", total_result=" + total_result +
                ", page_now=" + page_now +
                ", pagesize=" + pagesize +
                ", total_pages=" + total_pages +
                '}';
    }
}
