package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/8 17:17
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name) throws BeansException;
}
