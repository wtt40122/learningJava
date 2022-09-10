package com.wt.spring.test11.event;

import com.wt.spring.context.ApplicationEvent;
import com.wt.spring.context.event.ApplicationContextEvent;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 12:37
 */
public class CustomEvent extends ApplicationEvent {

    private Long id;
    private String message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
