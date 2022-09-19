package com.wt.spring.beans.factory;

import com.wt.spring.beans.BeansException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/16 16:16
 */
public interface ObjectFactory<T> {

    T getObjet() throws BeansException;
}
