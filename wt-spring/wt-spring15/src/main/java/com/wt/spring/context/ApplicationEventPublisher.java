package com.wt.spring.context;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 20:00
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
