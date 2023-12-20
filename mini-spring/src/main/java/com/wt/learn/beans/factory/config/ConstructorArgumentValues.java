package com.wt.learn.beans.factory.config;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:20
 * @Version: 1.0
 * @Description:
 */
public class ConstructorArgumentValues {
    private final List<ConstructorArgumentValue> constructorArgumentValueList = new LinkedList<>();

    public ConstructorArgumentValues() {
    }

    public void addArgumentValue(ConstructorArgumentValue newValue) {

        constructorArgumentValueList.add(newValue);
    }

    public ConstructorArgumentValue getIndexedArgumentValue(int index) {
        return this.constructorArgumentValueList.get(index);
    }

    public int getArgumentCount() {
        return constructorArgumentValueList.size();
    }

    public boolean isEmpty() {
        return constructorArgumentValueList.isEmpty();
    }
}
