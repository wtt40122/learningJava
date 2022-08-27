package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;

/**
 * @author: wtt
 * @date: 2022/8/27 15:12
 * @description:
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
