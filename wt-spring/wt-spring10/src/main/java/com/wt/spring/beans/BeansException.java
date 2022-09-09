package com.wt.spring.beans;

/**
 * @author: wtt
 * @date: 2022/8/27 15:32
 * @description:
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
