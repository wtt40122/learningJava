package com.wt.spring.beans.factory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 11:35
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
