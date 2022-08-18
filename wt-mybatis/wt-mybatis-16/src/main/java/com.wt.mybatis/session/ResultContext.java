package com.wt.mybatis.session;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/5 19:55
 */
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();
}
