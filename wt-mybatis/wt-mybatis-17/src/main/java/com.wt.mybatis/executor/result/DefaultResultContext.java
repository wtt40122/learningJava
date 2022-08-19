package com.wt.mybatis.executor.result;

import com.wt.mybatis.session.ResultContext;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/8/5 19:55
 */
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }
}
