package com.wt.server.servlet;

import com.wt.server.request.Request;
import com.wt.server.response.Response;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/10/15 15:59
 */
public abstract class HttpServlet implements Servlet {

    public abstract void doGet(Request request, Response response);

    public abstract void doPost(Request request, Response response);

    @Override
    public void service(Request request, Response response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }
}
