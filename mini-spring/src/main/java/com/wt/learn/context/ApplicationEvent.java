package com.wt.learn.context;

import java.util.EventObject;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:00
 * @Version: 1.0
 * @Description:
 */
public class ApplicationEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    protected String msg = null;

    public ApplicationEvent(Object arg0) {
        super(arg0);
        this.msg = arg0.toString();
    }
}
