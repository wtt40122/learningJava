package com.wt.mybatis.executor.keygen;

import com.wt.mybatis.executor.Executor;
import com.wt.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/16 9:43
 */
public class NoKeyGenerator implements KeyGenerator {
    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }
}
