package com.wt.mybatis.scripting.xmltags;

/**
 * @author wtt
 * @version 1.0
 * @description SQL 节点
 * @date 2022/8/2 20:14
 */
public interface SqlNode {

    boolean apply(DynamicContext context);

}
