package com.wt.spring.context.event;

import com.wt.spring.context.ApplicationEvent;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 16:33
 */
public class ContextClosedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
