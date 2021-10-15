package com.wt.server.response;

import com.wt.server.HttpProtocolUtil;
import com.wt.server.util.StaticResourceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/10/15 15:36
 */
public class Response {

    private OutputStream outputStream;

    private Response() {

    }

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void output(String content) throws IOException {
        outputStream.write(content.getBytes());
    }

    public void outputHtml(String path) throws IOException {
        String absoluteResourcePath = StaticResourceUtil.getAbsolutePath(path);

        File file = new File(absoluteResourcePath);

        if (file.exists() && file.isFile()) {
            StaticResourceUtil.outputStaticResource(new FileInputStream(file), outputStream);
        } else {
            output(HttpProtocolUtil.getHttpHeader404());
        }
    }
}
