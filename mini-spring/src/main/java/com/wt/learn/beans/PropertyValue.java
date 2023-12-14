package com.wt.learn.beans;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:05
 * @Version: 1.0
 * @Description:
 */
public class PropertyValue {

    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
