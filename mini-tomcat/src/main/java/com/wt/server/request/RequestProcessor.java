package com.wt.server.request;

import com.wt.server.response.Response;
import com.wt.server.servlet.HttpServlet;

import java.io.InputStream;
import java.net.Socket;
import java.util.Map;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/10/17 15:53
 */
public class RequestProcessor extends Thread {

    Socket socket;
    Map<String, HttpServlet> servletMap;

    public RequestProcessor(Socket socket, Map<String, HttpServlet> servletMap) {
        this.socket = socket;
        this.servletMap = servletMap;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());
            if (servletMap.containsKey(request.getUrl())) {
                HttpServlet httpServlet = servletMap.get(request.getUrl());
                httpServlet.service(request, response);
            } else {
                response.outputHtml(request.getUrl());
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
