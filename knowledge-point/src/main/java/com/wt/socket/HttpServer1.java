package com.wt.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/12/20 16:01
 */
@Slf4j
public class HttpServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (Exception e) {
                log.error("HttpServer1 service error", e);
            }
        }
    }

    private static void service(Socket socket) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("Http/1.1 200 OK");
        printWriter.println("Content-Type:text/html;charset=utf-8");
        String body = "hello,java01";
        printWriter.println("Content-Length:" + body.getBytes().length);
        printWriter.println();
        printWriter.write(body);
        printWriter.close();
        socket.close();
    }
}
