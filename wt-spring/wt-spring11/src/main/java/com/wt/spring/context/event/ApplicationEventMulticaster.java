package com.wt.spring.context.event;

import com.wt.spring.context.ApplicationEvent;
import com.wt.spring.context.ApplicationListener;

/**
 * @author wtt
 * @version 1.0
 * @description 事件广播器
 * @date 2022/9/9 16:36
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
