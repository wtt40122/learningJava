package com.wt.mybatis.executor.keygen;

import com.wt.mybatis.executor.Executor;
import com.wt.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/16 9:37
 */
public interface KeyGenerator {

    /**
     * 针对Sequence主键而言，在执行insert sql前必须指定一个主键值给要插入的记录，
     * 如Oracle、DB2，KeyGenerator提供了processBefore()方法。
     */
    void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter);

    /**
     * 针对自增主键的表，在插入时不需要主键，而是在插入过程自动获取一个自增的主键，
     * 比如MySQL、PostgreSQL，KeyGenerator提供了processAfter()方法
     */
    void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter);
}
