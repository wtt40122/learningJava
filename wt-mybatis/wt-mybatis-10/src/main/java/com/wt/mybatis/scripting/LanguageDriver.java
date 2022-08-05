package com.wt.mybatis.scripting;

import com.wt.mybatis.executor.parameter.ParameterHandler;
import com.wt.mybatis.mapping.BoundSql;
import com.wt.mybatis.mapping.MappedStatement;
import com.wt.mybatis.mapping.SqlSource;
import com.wt.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @author wtt
 * @version 1.0
 * @description  脚本语言驱动
 * @date 2022/8/2 20:09
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);
}
