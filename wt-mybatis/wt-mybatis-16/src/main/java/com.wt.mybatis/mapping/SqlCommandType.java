package com.wt.mybatis.mapping;

/**
 * @author: wtt
 * @date: 2022/7/31 20:04
 * @description:
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
