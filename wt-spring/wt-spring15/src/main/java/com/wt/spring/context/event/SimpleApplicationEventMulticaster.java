package com.wt.spring.context.event;

import com.wt.spring.beans.factory.BeanFactory;
import com.wt.spring.context.ApplicationEvent;
import com.wt.spring.context.ApplicationListener;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 19:44
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener applicationListener : getApplicationListeners(event)) {
            applicationListener.onApplicationEvent(event);
        }
    }

}
