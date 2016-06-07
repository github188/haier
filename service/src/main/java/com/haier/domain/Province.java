package com.haier.domain;

import java.util.List;

/**
 * Created by bright on 16-6-6.
 */
public class Province {
    private String value;
    private String text;
    private List<City> sub;
    public List<City> getSub() {
        return sub;
    }

    public void setSub(List<City> sub) {
        this.sub = sub;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
