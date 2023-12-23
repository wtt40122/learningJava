package com.wt.learn.context;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wtt
 * @Date: 2023/12/23 18:39
 * @Version: 1.0
 * @Description:
 */
public class SimpleApplicationEventPublisher implements ApplicationEventPublisher {
    List<ApplicationListener> listeners = new ArrayList<>();

    @Override
    public void publishEvent(ApplicationEvent event) {
        for (ApplicationListener listener : listeners) {
            listener.onApplicationEvent(event);
        }
    }

    @Override
    public void addApplicationListener(ApplicationListener listener) {
        listeners.add(listener);
    }
}
