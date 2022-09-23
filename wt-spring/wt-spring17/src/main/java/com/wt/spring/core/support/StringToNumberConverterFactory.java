package com.wt.spring.core.support;

import com.wt.spring.core.convert.Converter;
import com.wt.spring.core.convert.ConverterFactory;
import com.wt.spring.util.NumberUtils;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/22 19:20
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }

    private static class StringToNumber<T extends Number> implements Converter<String, T> {

        private final Class<T> targetType;

        private StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
