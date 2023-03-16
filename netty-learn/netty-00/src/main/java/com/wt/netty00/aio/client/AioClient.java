package com.wt.netty00.aio.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 11:20
 */
public class AioClient {

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        Future<Void> future = socketChannel.connect(new InetSocketAddress("127.0.0.1", 7397));
        System.out.println("demo-netty aio client start done.");
        future.get();
        socketChannel.read(ByteBuffer.allocate(1024), null, new AioClientHandler(socketChannel, Charset.forName("GBK")));
        Thread.sleep(100000);
    }
}
