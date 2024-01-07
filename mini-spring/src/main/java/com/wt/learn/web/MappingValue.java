package com.wt.learn.web;

/**
 * @Author: wtt
 * @Date: 2023/12/31 12:20
 * @Version: 1.0
 * @Description:
 */
public class MappingValue {
    private String uri;
    private String clz;
    private String method;

    public MappingValue(String uri, String method, String clz) {
        this.uri = uri;
        this.method = method;
        this.clz = clz;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
