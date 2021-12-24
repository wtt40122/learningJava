package com.wt.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/12/21 20:08
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端已经启动");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接了");
            executorService.submit(() -> {
                handle(socket);
            });
        }
    }

    private static void handle(Socket socket) {
        System.out.println("线程Id:" + Thread.currentThread().getId() + " 线程名:" + Thread.currentThread().getName());
        try {
            // 从连接中去除输入流来接受参数
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println("客户端：" + new String(bytes, 0, read));
            // 连接中取出输出流并回话
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是服务器".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
