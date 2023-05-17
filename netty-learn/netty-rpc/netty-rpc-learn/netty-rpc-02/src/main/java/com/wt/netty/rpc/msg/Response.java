package com.wt.netty.rpc.msg;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/9 9:35
 */
public class Response {
    private String requestId;
    private String param;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
