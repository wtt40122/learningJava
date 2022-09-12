package com.wt.spring.context;

import java.util.EventObject;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/9 16:27
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
