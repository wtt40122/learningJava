package com.wt.mybatis.scripting.xmltags;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/2 20:16
 */
public class StaticTextSqlNode implements SqlNode {

    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public boolean apply(DynamicContext context) {
        //将文本加入context
        context.appendSql(text);
        return true;
    }

}
