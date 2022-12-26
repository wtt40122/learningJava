package com.wt.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: wtt
 * @Date: 2021/4/16 18:08
 * @Description:
 */
public class UrlUtil {
    private static Pattern linePattern = Pattern.compile("/(\\w)");

    // 驼峰转斜线
    public static String humpToSlash(String str) {

        StringBuilder sb = new StringBuilder("/");

        sb.append(str.replaceAll("[A-Z]", "/$0").toLowerCase());

        return sb.toString();
    }

    // 斜线转驼峰
    public static String slashToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }

        matcher.appendTail(sb);
        return sb.toString();
    }


    public static void main(String[] args) {

        String rest = "sayHelloWWorld";
        System.out.println(humpToSlash(rest));

        String rest1 = "say/hello";
        System.out.println(slashToHump(rest1));
    }
}
