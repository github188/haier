package com.haier.domain;

import java.util.List;

/**
 * Created by bright on 16-6-6.
 */
public class Province {
    private String code;
    private String name;

    public List<City> getSub() {
        return sub;
    }

    public void setSub(List<City> sub) {
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private List<City> sub;
}
