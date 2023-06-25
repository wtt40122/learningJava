package com.wt.regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/1/2 11:03
 */
public class RegexTest {
    private static final Pattern NEW_LINE_PATTERN = Pattern.compile("^20[0-9]{2}|^\\[20[0-9]{2}");

    @Test
    public void test1() {
        String str = "201223424234";
        Pattern compile = NEW_LINE_PATTERN.compile(str);
        boolean isTrue = compile.matcher(str).find();
        Assert.assertEquals(true, isTrue);
    }

    @Test
    public void test2() {
        String str = "abcd324232efg";
        Pattern pattern = Pattern.compile("([a-z]*)(\\d*)([a-z]*)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }
}
