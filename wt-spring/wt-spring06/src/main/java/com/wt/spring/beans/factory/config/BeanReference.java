package com.wt.spring.beans.factory.config;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 15:08
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
