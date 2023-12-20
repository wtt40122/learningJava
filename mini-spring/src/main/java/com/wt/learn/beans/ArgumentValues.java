package com.wt.learn.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:20
 * @Version: 1.0
 * @Description:
 */
public class ArgumentValues {
    private final List<ArgumentValue> argumentValueList = new LinkedList<>();

    public ArgumentValues() {
    }

    public void addArgumentValue(ArgumentValue newValue) {

        argumentValueList.add(newValue);
    }

    public ArgumentValue getIndexedArgumentValue(int index) {
        return this.argumentValueList.get(index);
    }

    public int getArgumentCount() {
        return argumentValueList.size();
    }

    public boolean isEmpty() {
        return argumentValueList.isEmpty();
    }
}
