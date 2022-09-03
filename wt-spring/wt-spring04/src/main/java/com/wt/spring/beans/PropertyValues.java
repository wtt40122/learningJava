package com.wt.spring.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 14:48
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        return propertyValueList.stream()
                .filter(propertyValue -> Objects.equals(propertyValue.getName(), propertyName))
                .findFirst()
                .orElse(null);
    }
}
