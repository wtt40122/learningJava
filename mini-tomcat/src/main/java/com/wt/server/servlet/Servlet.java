package com.wt.server.servlet;

import com.wt.server.request.Request;
import com.wt.server.response.Response;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/10/15 15:58
 */
public interface Servlet {

    void init() throws Exception;

    void destroy() throws Exception;

    void service(Request request, Response response) throws Exception;
}
