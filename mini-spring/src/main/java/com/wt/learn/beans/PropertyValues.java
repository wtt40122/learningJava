package com.wt.learn.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:33
 * @Version: 1.0
 * @Description:
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues() {
        propertyValueList = new ArrayList<>();
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public int size() {
        return propertyValueList.size();
    }

    public void addPropertyValue(PropertyValue pValue) {
        propertyValueList.add(pValue);
    }

//    public void addPropertyValue(String propertyName, Object pValue) {
//        propertyValueList.add(new PropertyValue(propertyName, pValue));
//
//    }

    public void removePropertyValue(PropertyValue pValue) {
        propertyValueList.remove(pValue);
    }

    public void removePropertyValue(String propertyName) {
        propertyValueList.remove(getPropertyValue(propertyName));
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[this.propertyValueList.size()]);
    }

    private PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

    public Object get(String propertyName) {
        PropertyValue pv = getPropertyValue(propertyName);
        return pv != null ? pv.getValue() : null;
    }

    public boolean contains(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }

    public boolean isEmpty() {
        return this.propertyValueList.isEmpty();
    }
}
