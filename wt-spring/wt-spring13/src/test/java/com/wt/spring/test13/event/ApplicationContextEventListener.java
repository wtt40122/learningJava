package com.wt.spring.test13.event;

import com.wt.spring.context.ApplicationListener;
import com.wt.spring.context.event.ApplicationContextEvent;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 13:03
 */
public class ApplicationContextEventListener implements ApplicationListener<ApplicationContextEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        System.out.println("应用上下文事件：" + event.getClass().getSimpleName());
    }
}
