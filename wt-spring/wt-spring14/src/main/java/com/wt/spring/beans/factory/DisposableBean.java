package com.wt.spring.beans.factory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/7 20:00
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
