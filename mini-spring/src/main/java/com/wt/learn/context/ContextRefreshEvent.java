package com.wt.learn.context;

/**
 * @Author: wtt
 * @Date: 2023/12/23 18:38
 * @Version: 1.0
 * @Description:
 */
public class ContextRefreshEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public ContextRefreshEvent(Object arg0) {
        super(arg0);
    }

    public String toString() {
        return this.msg;
    }
}
