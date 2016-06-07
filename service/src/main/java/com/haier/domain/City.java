package com.haier.domain;

import java.util.List;

/**
 * Created by bright on 16-6-6.
 */
public class City {
    private String value;
    private String text;
    private List<Area> sub;
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

    public List<Area> getSub() {
        return sub;
    }

    public void setSub(List<Area> sub) {
        this.sub = sub;
    }

}
