package com.wt.learn.context;

import com.wt.learn.beans.BeansException;
import com.wt.learn.beans.factory.ListableBeanFactory;
import com.wt.learn.beans.factory.config.BeanFactoryPostProcessor;
import com.wt.learn.beans.factory.config.ConfigurableBeanFactory;
import com.wt.learn.beans.factory.config.ConfigurableListableBeanFactory;
import com.wt.learn.core.env.Environment;
import com.wt.learn.core.env.EnvironmentCapable;

/**
 * @Author: wtt
 * @Date: 2023/12/23 18:41
 * @Version: 1.0
 * @Description:
 */
public interface ApplicationContext extends EnvironmentCapable,
        ListableBeanFactory, ConfigurableBeanFactory, ApplicationEventPublisher {
    String getApplicationName();

    long getStartupDate();

    ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;

    void setEnvironment(Environment environment);

    Environment getEnvironment();

    void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);

    void refresh() throws BeansException, IllegalStateException;

    void close();

    boolean isActive();
}
