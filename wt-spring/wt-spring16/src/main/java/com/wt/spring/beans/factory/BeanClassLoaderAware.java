package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/8 17:16
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader beanClassLoader) throws BeansException;
}
