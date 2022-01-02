package com.wt.regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/2 11:03
 */
public class RegexTest {
    private final Pattern NEW_LINE_PATTERN = Pattern.compile("^20[0-9]{2}|^\\[20[0-9]{2}");

    @Test
    public void test1() {
        String str = "201223424234";
        Pattern compile = NEW_LINE_PATTERN.compile(str);
        boolean isTrue = compile.matcher(str).find();
        Assert.assertEquals(true, isTrue);
    }
}
