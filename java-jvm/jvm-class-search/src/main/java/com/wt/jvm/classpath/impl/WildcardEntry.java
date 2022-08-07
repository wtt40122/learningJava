package com.wt.jvm.classpath.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author: wtt
 * @date: 2022/8/6 19:40
 * @description:
 */
public class WildcardEntry extends CompositeEntry {
    public WildcardEntry(String path) {
        super(toPathList(path));
    }

    private static String toPathList(String wildcardPath) {
        String baseDir = wildcardPath.replace("*", ""); // remove *
        try {
            return Files.walk(Paths.get(baseDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                    .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            return "";
        }
    }
}
