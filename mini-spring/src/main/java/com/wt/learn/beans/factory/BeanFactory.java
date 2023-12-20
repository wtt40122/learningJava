package com.wt.learn.beans.factory;

import com.wt.learn.beans.BeansException;

/**
 * @Author: wtt
 * @Date: 2023/12/14 0:41
 * @Version: 1.0
 * @Description:
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    boolean containsBean(String name);

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class<?> getType(String name);
}
