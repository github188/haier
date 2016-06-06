package com.haier.domain;

import java.util.List;

/**
 * Created by bright on 16-6-6.
 */
public class City {
    private String code;
    private String name;

    public List<Area> getSub() {
        return sub;
    }

    public void setSub(List<Area> sub) {
        this.sub = sub;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Area> sub;
}
