package com.wt.server.util;

import com.wt.server.HttpProtocolUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2021/10/15 15:22
 */
public class StaticResourceUtil {


    public static String getAbsolutePath(String path) {
        String absolutePath = StaticResourceUtil.class.getResource("/").getPath();
        return absolutePath.replaceAll("\\\\", "/") + path;
    }

    public static void outputStaticResource(InputStream inputStream, OutputStream outputStream) throws IOException {
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }
        int resourceSize = count;
        outputStream.write(HttpProtocolUtil.getHttpHeader200(resourceSize).getBytes());

        //读取内容输出
        long written = 0;
        int byteSize = 1024;
        byte[] bytes = new byte[byteSize];
        while (written < resourceSize) {
            // 说明剩余未读取大小不足一个1024长度，那就按真实长度处理
            if (resourceSize - byteSize < written) {
                // 剩余的文件内容长度
                byteSize = (int) (resourceSize - written);
                bytes = new byte[byteSize];
            }
            inputStream.read(bytes);
            outputStream.write(bytes);

            outputStream.flush();
            outputStream.close();
            written += byteSize;
        }
    }
}
