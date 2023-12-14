package com.wt.learn.beans;

import java.util.*;

/**
 * @Author: wtt
 * @Date: 2023/12/14 23:20
 * @Version: 1.0
 * @Description:
 */
public class ArgumentValues {
    private final Map<Integer, ArgumentValue> indexedArguments = new HashMap<>();
    private final List<ArgumentValue> genericArguments = new LinkedList<>();

    public ArgumentValues() {
    }

    private void addArgumentValue(Integer key, ArgumentValue newValue) {
        indexedArguments.put(key, newValue);
    }

    public boolean hasIndexedArgumentValue(int index) {
        return indexedArguments.containsKey(index);
    }

    public ArgumentValue getIndexedArgumentValue(int index) {
        return indexedArguments.get(index);
    }

    public void addGenericArgumentValue(int index, ArgumentValue argumentValue) {
        indexedArguments.put(index, argumentValue);
    }

    private void addGenericArgumentValue(ArgumentValue newValue) {
        if (null != newValue.getName()) {
            Iterator<ArgumentValue> iterator = genericArguments.iterator();
            while (iterator.hasNext()) {
                ArgumentValue argumentValue = iterator.next();
                if (newValue.getName().equals(argumentValue.getName())) {
                    iterator.remove();
                }
            }
        }
        genericArguments.add(newValue);
    }

    public ArgumentValue getGenericArgumentValue(String requiredName) {
        for (ArgumentValue valueHolder : this.genericArguments) {
            if (valueHolder.getName() != null && (requiredName == null || !valueHolder.getName().equals(requiredName))) {
                continue;
            }
            return valueHolder;
        }
        return null;
    }

    public int getArgumentCount() {
        return genericArguments.size();
    }

    public boolean isEmpty() {
        return genericArguments.isEmpty();
    }
}
