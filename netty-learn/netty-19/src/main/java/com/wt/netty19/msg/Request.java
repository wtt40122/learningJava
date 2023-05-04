package com.wt.netty19.msg;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 16:18
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
