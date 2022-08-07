package com.wt.jvm.classpath.impl;

import com.wt.jvm.classpath.Entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: wtt
 * @date: 2022/8/6 19:39
 * @description:
 */
public class DirEntry implements Entry {
    private Path absolutePath;

    public DirEntry(String path) {
        //获取绝对路径
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absolutePath.resolve(className));
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}
