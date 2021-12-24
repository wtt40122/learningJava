package com.wt.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/12/21 20:17
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        outputStream.write(msg.getBytes());
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int read = inputStream.read(bytes);
        System.out.println("服务端发来的消息：" + new String(bytes, 0, read));
        socket.close();
    }
}
