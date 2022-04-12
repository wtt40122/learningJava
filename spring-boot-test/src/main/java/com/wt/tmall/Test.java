package com.wt.tmall;

import java.util.regex.Pattern;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/12 14:51
 */
public class Test {
    public static void main(String[] args) {
        String str = "/home/work/log/commission-compare-pos/app.*";
        String compileStr = "/home/work/log/commission-compare-pos/app.2022-04-12-12.0.log";
        Pattern compile = Pattern.compile(str);
        System.out.println(compile.matcher(compileStr).matches());
    }
}
