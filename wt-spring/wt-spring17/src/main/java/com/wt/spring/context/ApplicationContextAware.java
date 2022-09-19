package com.wt.spring.context;

import com.wt.spring.beans.BeansException;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/8 20:29
 */
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
