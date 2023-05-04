package com.wt.netty19.msg;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/4 16:18
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
