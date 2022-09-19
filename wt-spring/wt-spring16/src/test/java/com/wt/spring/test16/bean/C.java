package com.wt.spring.test16.bean;

import com.wt.spring.beans.factory.annotation.Autowired;
import com.wt.spring.stereotype.Component;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/19 11:15
 */
@Component
public class C {
    @Autowired
    private A a;
    public String query() {
        return "测试C";
    }
}
