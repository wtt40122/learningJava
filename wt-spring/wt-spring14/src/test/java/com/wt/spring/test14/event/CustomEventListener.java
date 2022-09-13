package com.wt.spring.test14.event;

import com.wt.spring.context.ApplicationListener;

import java.util.Date;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 12:38
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + " 消息;时间:" + new Date());
        System.out.println("消息：" + event.getId() + " :" + event.getMessage());
    }
}
