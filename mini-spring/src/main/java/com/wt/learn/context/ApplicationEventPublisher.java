package com.wt.learn.context;

/**
 * @Author: wtt
 * @Date: 2023/12/14 22:59
 * @Version: 1.0
 * @Description:
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

    void addApplicationListener(ApplicationListener listener);
}
