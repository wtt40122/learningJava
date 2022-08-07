package com.wt.jvm.classpath.impl;

import com.wt.jvm.classpath.Entry;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author: wtt
 * @date: 2022/8/6 19:40
 * @description:
 */
public class ZipEntry implements Entry {
    private Path absolutePath;

    public ZipEntry(String path) {
        //获取绝对路径
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        try (FileSystem zipFs = FileSystems.newFileSystem(absolutePath, null)) {
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }

}
