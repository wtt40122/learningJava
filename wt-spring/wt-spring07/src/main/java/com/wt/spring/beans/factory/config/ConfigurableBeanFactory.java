package com.wt.spring.beans.factory.config;

import com.wt.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 17:19
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,
        SingleBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}
