package com.wt.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/26 22:07
 */
@ConfigurationProperties(value = "wt.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
