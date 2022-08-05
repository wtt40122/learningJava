package com.wt.mybatis.executor.statement;

import com.wt.mybatis.executor.Executor;
import com.wt.mybatis.mapping.BoundSql;
import com.wt.mybatis.mapping.MappedStatement;
import com.wt.mybatis.session.ResultHandler;
import com.wt.mybatis.session.RowBounds;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author wtt
 * @version 1.0
 * @description 简单语句处理器（STATEMENT）
 * @date 2022/8/1 21:06
 */
public class SimpleStatementHandler extends BaseStatementHandler {
    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, rowBounds, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // N/A
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }

}
