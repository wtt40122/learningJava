package com.wt.netty.rpc.network.future;

import com.wt.netty.rpc.network.msg.Response;

import java.util.concurrent.Future;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/10 9:50
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
