package com.wt.spring.core.support;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/22 17:20
 */
public class DefaultConversionService extends GenericConversionService {
    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    private void addDefaultConverters(DefaultConversionService defaultConversionService) {
        defaultConversionService.addConverterFactory(new StringToNumberConverterFactory());
    }

}
