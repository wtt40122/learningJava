package com.wt.netty.rpc.msg;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/9 9:34
 */
public class Request {

    private String requestId;
    private Object result;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
