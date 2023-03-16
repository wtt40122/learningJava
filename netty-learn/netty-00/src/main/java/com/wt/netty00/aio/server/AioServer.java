package com.wt.netty00.aio.server;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 11:06
 */
public class AioServer extends Thread {

    private AsynchronousServerSocketChannel serverSocketChannel;

    public static void main(String[] args) {
        new AioServer().start();
    }

    @Override
    public synchronized void start() {
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open(AsynchronousChannelGroup.withCachedThreadPool(
                    Executors.newCachedThreadPool(), 10
            ));
            serverSocketChannel.bind(new InetSocketAddress(7397));
            System.out.println("demo-netty aio server start done.");
            CountDownLatch latch = new CountDownLatch(1);
            serverSocketChannel.accept(this, new AioServerChannelInitializer());
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AsynchronousServerSocketChannel getserverSocketChannel() {
        return serverSocketChannel;
    }
}
