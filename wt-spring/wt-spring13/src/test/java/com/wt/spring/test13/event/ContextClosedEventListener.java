package com.wt.spring.test13.event;

import com.wt.spring.context.ApplicationListener;
import com.wt.spring.context.event.ContextClosedEvent;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 12:46
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName() + ":" + getClass().getSimpleName());
    }
}
