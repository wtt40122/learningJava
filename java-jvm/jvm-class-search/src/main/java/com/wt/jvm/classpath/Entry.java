package com.wt.jvm.classpath;

import com.wt.jvm.classpath.impl.CompositeEntry;
import com.wt.jvm.classpath.impl.DirEntry;
import com.wt.jvm.classpath.impl.WildcardEntry;
import com.wt.jvm.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * @author: wtt
 * @date: 2022/8/6 19:39
 * @description:
 */
public interface Entry {

    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);
    }
}
