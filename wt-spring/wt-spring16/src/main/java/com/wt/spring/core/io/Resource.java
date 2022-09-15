package com.wt.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/3 16:13
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
