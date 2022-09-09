package com.wt.spring.beans;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 14:47
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
