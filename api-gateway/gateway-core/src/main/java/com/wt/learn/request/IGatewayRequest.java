package com.wt.learn.request;

import io.netty.handler.codec.http.cookie.Cookie;

/**
 * @Author: wtt
 * @Date: 2023/7/4 22:24
 * @Version: 1.0
 * @Description:
 */
public interface IGatewayRequest {

    void setModifyHost(String host);

    String getModifyHost();

    void setModifyPath(String path);

    String getModifyPath();

    void addHeader(CharSequence name, String value);

    void setHeader(CharSequence name, String value);

    void addQueryParam(String name, String value);

    void addFormParam(String name, String value);

    void addOrReplaceCookie(Cookie cookie);

    void setRequestTimeout(int requestTimeout);

    String getFinalUrl();

    IGatewayRequest build();
}
