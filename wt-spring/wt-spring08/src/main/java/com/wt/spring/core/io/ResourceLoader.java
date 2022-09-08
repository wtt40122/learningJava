package com.wt.spring.core.io;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 16:26
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
