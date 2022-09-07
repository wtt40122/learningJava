package com.wt.spring.context;

import com.wt.spring.beans.BeansException;

/**
 * @author: wtt
 * @date: 2022/9/4 17:23
 * @description:
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();
}
