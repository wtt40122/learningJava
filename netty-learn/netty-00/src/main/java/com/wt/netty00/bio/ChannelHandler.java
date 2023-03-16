package com.wt.netty00.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/3/14 10:43
 */
public class ChannelHandler {
    private final Socket socket;
    private final Charset charset;

    public ChannelHandler(Socket socket, Charset charset) {
        this.socket = socket;
        this.charset = charset;
    }

    public void writeAndFlush(Object msg) {
        OutputStream outputStream;
        try {
            outputStream = socket.getOutputStream();
            outputStream.write(msg.toString().getBytes(charset));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket socket() {
        return socket;
    }

}
