package com.wt.learn.constants;

import java.util.regex.Pattern;

/**
 * @Author: wtt
 * @Date: 2023/7/4 23:16
 * @Version: 1.0
 * @Description:
 */
public interface BasicConst {

    String BAR_SEPARATOR = "-";

    String COLON_SEPARATOR = ":";

    String DIT_SEPARATOR = ".";
    String HTTP_PREFIX_SEPARATOR = "http://";

    String HTTPS_PREFIX_SEPARATOR = "https://";
    String HTTP_FORWARD_SEPARATOR = "X-Forwarded-For";

    Pattern PARAM_PATTERN = Pattern.compile("\\{(.*?)\\}");

    String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    String ENABLE = "Y";
    String DISABLE = "N";
}
