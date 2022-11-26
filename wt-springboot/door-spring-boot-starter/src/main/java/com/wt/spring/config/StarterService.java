package com.wt.spring.config;

import org.springframework.util.StringUtils;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/26 22:10
 */
public class StarterService {

    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(userStr, separatorChar);
    }
}
