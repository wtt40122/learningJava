package com.wt.learn.beans.factory.config;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:04
 * @Version: 1.0
 * @Description:
 */
public class ConstructorArgumentValue {

    private String type;
    private String name;
    private Object value;

    public ConstructorArgumentValue(Object value, String type) {
        this.value = value;
        this.type = type;
    }

    public ConstructorArgumentValue(String type, String name, Object value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
