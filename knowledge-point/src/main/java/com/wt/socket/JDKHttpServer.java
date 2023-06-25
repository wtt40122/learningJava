package com.wt.socket;

import cn.hutool.json.JSONUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wtt
 * @version 1.0
 * @description jdk自带的httpserver，满足大多数需求
 * @date 2023/6/12 11:20
 */
public class JDKHttpServer {
    public static void main(String[] args) throws IOException {
        // 创建HttpServer实例，并绑定到指定的IP地址和端口
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8000), 0);
        // 创建处理HTTP请求的处理程序
        HttpHandler handler = new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hello, World!"; // 响应消息内容

                // 设置响应头信息
                exchange.getResponseHeaders().set("Content-Type", "text/plain");
                exchange.sendResponseHeaders(200, response.length());

                // 发送响应消息
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            }
        };

        // 将处理程序与指定的URL路径关联
        server.createContext("/", handler);

        HttpHandler handlerMethod = new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String requestMethod = exchange.getRequestMethod();
                Map<String, String> queryStringInfo;
                if (Objects.equals("GET", requestMethod)) {
                    String queryString = exchange.getRequestURI().getQuery();
                    queryStringInfo = formData2Dic(queryString);
                } else {
                    String postString = IOUtils.toString(exchange.getRequestBody(), StandardCharsets.UTF_8);
                    queryStringInfo = formData2Dic(postString);
                }
                String response = JSONUtil.toJsonStr(queryStringInfo); // 响应消息内容

                System.out.println(queryStringInfo);
                // 设置响应头信息
                exchange.getResponseHeaders().set("Content-Type", "text/plain");
                exchange.sendResponseHeaders(200, response.length());

                // 发送响应消息
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            }
        };
        server.createContext("/test/data", handlerMethod);

        // 启动HTTP服务器
        server.start();
        System.out.println("HTTP服务器已启动，监听端口: " + server.getAddress().getPort());
    }

    public static Map<String, String> formData2Dic(String formData) {
        Map<String, String> result = new HashMap<>();
        if (formData == null || formData.trim().length() == 0) {
            return result;
        }
        final String[] items = formData.split("&");
        Arrays.stream(items).forEach(item -> {
            final String[] keyAndVal = item.split("=");
            if (keyAndVal.length == 2) {
                try {
                    final String key = URLDecoder.decode(keyAndVal[0], "utf8");
                    final String val = URLDecoder.decode(keyAndVal[1], "utf8");
                    result.put(key, val);
                } catch (UnsupportedEncodingException e) {
                }
            }
        });
        return result;
    }
}
