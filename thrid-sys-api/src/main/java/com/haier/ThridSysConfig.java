package com.haier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ehl on 2016/6/5.
 */
@Component
public class ThridSysConfig {
    @Value("#{config['hp.url']}")
    public String hpUrl;
    @Value("#{config['hp.access.token']}")
    public String hpToken;

    public String getHpUrl() {
        return hpUrl;
    }

    public void setHpUrl(String hpUrl) {
        this.hpUrl = hpUrl;
    }

    public String getHpToken() {
        return hpToken;
    }

    public void setHpToken(String hpToken) {
        this.hpToken = hpToken;
    }
}
