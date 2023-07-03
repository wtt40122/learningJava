package com.wt.learn.context;

import io.netty.channel.ChannelHandlerContext;

import java.util.function.Consumer;

/**
 * @Author: wtt
 * @Date: 2023/7/3 22:36
 * @Description:
 */
public interface IContext {
    /**
     * 上下文生命周期，运行中状态
     */
    int Running = 1;

    /**
     * 运行过程中发生错误，对其进行标记，告诉我们请求已经结束，需要返回客户端
     */
    int Written = 0;

    /**
     * 标记写回成功,防止并发情况下的多次写回
     */
    int Completed = 1;

    /**
     * 表示网关请求结束
     */
    int Terminated = 2;

    /**
     * 设置上下文状态为运行中
     */
    void runned();

    /**
     * 设置上下文状态为标记写回
     */
    void writtened();

    /**
     * 设置上下文状态为标记写回成功
     */
    void completed();

    /**
     * 设置上下文状态为请求结束
     */
    void terminated();


    boolean isRunning();

    boolean isWritten();

    boolean isCompleted();

    boolean isTerminated();

    String getProtocol();

    Object getRequest();

    Object getResponse();

    void setResponse(Object response);

    Throwable getThrowable();

    void setThrowable(Throwable throwable);

    ChannelHandlerContext getNettyCtx();

    boolean isKeepAlive();

    boolean releaseRequest();

    /**
     * 设置写回接受回调函数
     *
     * @param consumer
     */
    void setCompletedCallback(Consumer<IContext> consumer);


    /**
     * 执行写回接受回调函数
     *
     * @param consumer
     */
    void invokeCompletedCallback(Consumer<IContext> consumer);
}
