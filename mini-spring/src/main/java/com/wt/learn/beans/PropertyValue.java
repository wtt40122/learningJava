package com.wt.learn.beans;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:05
 * @Version: 1.0
 * @Description:
 */
public class PropertyValue {

    private final String type;
    private final String name;
    private final Object value;
    private final boolean isRef;

    public PropertyValue(String type, String name, Object value, boolean isRef) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.isRef = isRef;
    }

    public boolean getIsRef() {
        return isRef;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
