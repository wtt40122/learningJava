package com.wt.spring.context;

import java.util.EventListener;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 16:37
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
