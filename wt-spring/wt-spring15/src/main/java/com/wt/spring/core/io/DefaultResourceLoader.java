package com.wt.spring.core.io;

import cn.hutool.core.lang.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 16:28
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(new File(location));
            }

        }
    }
}
