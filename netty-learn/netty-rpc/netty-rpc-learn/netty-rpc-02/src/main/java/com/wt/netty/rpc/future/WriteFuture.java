package com.wt.netty.rpc.future;

import com.wt.netty.rpc.msg.Response;

import java.util.concurrent.Future;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/9 9:43
 */
public interface WriteFuture<T> extends Future<T> {

    Throwable cause();

    void setCause(Throwable cause);

    boolean isWriteSuccess();

    void setWriteResult(boolean result);

    String requestId();

    T response();

    void setResponse(Response response);

    boolean isTimeout();

}
