package com.wt.learn.context;

import java.util.EventListener;

/**
 * @Author: wtt
 * @Date: 2023/12/23 18:37
 * @Version: 1.0
 * @Description:
 */
public class ApplicationListener implements EventListener {
    void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.toString());
    }
}
