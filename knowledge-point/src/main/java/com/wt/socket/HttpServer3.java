package com.wt.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/12/20 16:01
 */
@Slf4j
public class HttpServer3 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
        ServerSocket serverSocket = new ServerSocket(8803);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (Exception e) {
                log.error("HttpServer1 service error", e);
            }
        }
    }

    private static void service(Socket socket) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Http/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,java03";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
