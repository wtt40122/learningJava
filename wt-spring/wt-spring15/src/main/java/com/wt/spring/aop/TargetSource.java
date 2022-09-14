package com.wt.spring.aop;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/10 17:14
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
