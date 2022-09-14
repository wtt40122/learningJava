package com.wt.spring.beans.factory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/7 19:58
 */
public interface InitializingBean {
    /**
     * 属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
