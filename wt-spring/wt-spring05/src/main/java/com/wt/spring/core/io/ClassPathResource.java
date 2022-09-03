package com.wt.spring.core.io;

import cn.hutool.core.lang.Assert;
import com.wt.spring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 16:14
 */
public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = null != classLoader ? classLoader : ClassUtils.getClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (null == is) {
            throw new FileNotFoundException(this.path + " can not be opened because it does not exist");
        }
        return is;
    }
}
