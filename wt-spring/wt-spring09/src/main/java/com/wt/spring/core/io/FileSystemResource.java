package com.wt.spring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 16:20
 */
public class FileSystemResource implements Resource {

    private final File file;
    private final String path;

    public String getPath() {
        return path;
    }

    public FileSystemResource(File file, String path) {
        this.file = file;
        this.path = path;
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
}
