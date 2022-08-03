package com.wt.mybatis.mapping;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/2 20:10
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);
}
