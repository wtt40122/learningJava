package com.wt.mybatis.builder;

import com.wt.mybatis.session.Configuration;
import com.wt.mybatis.type.TypeAliasRegistry;
import com.wt.mybatis.type.TypeHandlerRegistry;

/**
 * @author: wtt
 * @date: 2022/7/31 19:14
 * @description:
 */
public class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;
    protected final TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }

}
