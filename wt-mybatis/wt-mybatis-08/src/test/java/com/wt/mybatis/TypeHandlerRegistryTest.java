package com.wt.mybatis;

import com.wt.mybatis.type.TypeHandlerRegistry;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/3 10:21
 */
public class TypeHandlerRegistryTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {
        final TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry();
        boolean contain = typeHandlerRegistry.hasTypeHandler(Long.TYPE);
        logger.info("has contain:{}", contain);
    }
}
