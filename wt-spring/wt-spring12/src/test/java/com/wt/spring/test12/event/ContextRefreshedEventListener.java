package com.wt.spring.test12.event;

import com.wt.spring.context.ApplicationListener;
import com.wt.spring.context.event.ContextRefreshedEvent;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 12:51
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
