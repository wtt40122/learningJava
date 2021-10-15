package com.wt.server.servlet;

import com.wt.server.HttpProtocolUtil;
import com.wt.server.request.Request;
import com.wt.server.response.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/10/15 16:02
 */
public class DefaultServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) {

        String content = "<h1>DefaultServer GET<h1>";
        try {
            TimeUnit.SECONDS.sleep(1);
            response.output(HttpProtocolUtil.getHttpHeader200(content.getBytes().length) + content);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        String content = "<h1>DefaultServer POST<h1>";
        try {
            TimeUnit.SECONDS.sleep(1);
            response.output(HttpProtocolUtil.getHttpHeader200(content.getBytes().length) + content);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }
}
