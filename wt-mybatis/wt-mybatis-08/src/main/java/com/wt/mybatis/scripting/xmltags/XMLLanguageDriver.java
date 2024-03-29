package com.wt.mybatis.scripting.xmltags;

import com.wt.mybatis.mapping.SqlSource;
import com.wt.mybatis.scripting.LanguageDriver;
import com.wt.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/3 17:02
 */
public class XMLLanguageDriver implements LanguageDriver {
    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

}
