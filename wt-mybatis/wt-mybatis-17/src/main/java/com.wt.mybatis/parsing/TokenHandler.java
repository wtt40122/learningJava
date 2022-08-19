package com.wt.mybatis.parsing;

/**
 * @author wtt
 * @version 1.0
 * @description 记号处理器
 * @date 2022/8/2 20:31
 */
public interface TokenHandler {
    String handleToken(String content);
}
