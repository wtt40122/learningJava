package com.wt.spring.test17.converter;

import com.wt.spring.core.convert.Converter;

public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }

}
