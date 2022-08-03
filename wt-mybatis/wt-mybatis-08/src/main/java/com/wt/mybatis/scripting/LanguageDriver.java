package com.wt.mybatis.scripting;

import com.wt.mybatis.mapping.SqlSource;
import com.wt.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @author wtt
 * @version 1.0
 * @description 脚本语言驱动
 * @date 2022/8/2 20:09
 */
public interface LanguageDriver {

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);
}
