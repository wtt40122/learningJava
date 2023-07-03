package com.wt.learn.context;

import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/**
 * @Author: wtt
 * @Date: 2023/7/3 23:42
 * @Version: 1.0
 * @Description:
 */
public class BaseContext implements IContext {
    //转发协议
    protected final String protocol;

    protected volatile int status = Running;

    protected final ChannelHandlerContext nettyCtx;

    protected final Map<String, Object> attributes = new HashMap<>();

    protected Throwable throwable;

    protected final boolean keepAlive;

    protected List<Consumer<IContext>> completedCallbacks;

    protected final AtomicBoolean requestReleased = new AtomicBoolean(false);

    public BaseContext(String protocol, ChannelHandlerContext nettyCtx, boolean keepAlive) {
        this.protocol = protocol;
        this.nettyCtx = nettyCtx;
        this.keepAlive = keepAlive;
    }

    @Override
    public void runned() {
        status = Running;
    }

    @Override
    public void writtened() {
        status = Written;
    }

    @Override
    public void completed() {
        status = Completed;
    }

    @Override
    public void terminated() {
        status = Terminated;
    }

    @Override
    public boolean isRunning() {
        return status == Running;
    }

    @Override
    public boolean isWritten() {
        return status == Written;
    }

    @Override
    public boolean isCompleted() {
        return status == Completed;
    }

    @Override
    public boolean isTerminated() {
        return status == Terminated;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public Object getRequest() {
        return null;
    }

    @Override
    public Object getResponse() {
        return null;
    }

    @Override
    public void setResponse(Object response) {

    }

    @Override
    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public ChannelHandlerContext getNettyCtx() {
        return nettyCtx;
    }

    @Override
    public boolean isKeepAlive() {
        return keepAlive;
    }

    @Override
    public boolean releaseRequest() {
        return false;
    }

    @Override
    public void setCompletedCallback(Consumer<IContext> consumer) {
        if (null == completedCallbacks) {
            completedCallbacks = new ArrayList();
        }
        completedCallbacks.add(consumer);
    }

    @Override
    public void invokeCompletedCallback(Consumer<IContext> consumer) {
        if (null == completedCallbacks) {
            for (Consumer<IContext> completedCallback : completedCallbacks) {
                completedCallback.accept(this);
            }
        }
    }
}
