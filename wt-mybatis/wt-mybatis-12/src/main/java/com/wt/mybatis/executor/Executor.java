package com.wt.mybatis.executor;

import com.wt.mybatis.mapping.BoundSql;
import com.wt.mybatis.mapping.MappedStatement;
import com.wt.mybatis.session.ResultHandler;
import com.wt.mybatis.session.RowBounds;
import com.wt.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description 执行器
 * @date 2022/8/1 20:55
 */
public interface Executor {
    ResultHandler NO_RESULT_HANDLER = null;

    int update(MappedStatement ms, Object parameter) throws SQLException;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);
}
