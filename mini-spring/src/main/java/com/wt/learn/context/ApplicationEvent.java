package com.wt.learn.context;

import java.util.EventObject;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:00
 * @Version: 1.0
 * @Description:
 */
public class ApplicationEvent extends EventObject {
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
