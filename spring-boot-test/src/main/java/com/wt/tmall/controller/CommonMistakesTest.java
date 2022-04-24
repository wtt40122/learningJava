package com.wt.tmall.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/19 10:14
 */
public class CommonMistakesTest {
    public static void main(String[] args) {
        wrong();
        wrongfix();
        right();
    }

    private static void wrong() {
        System.out.println("wrong");
        Date date = new Date(2019, 12, 31, 11, 12, 13);
        System.out.println(date);
    }

    private static void wrongfix() {
        System.out.println("right");
        Date date = new Date(2019 - 1900, 11, 31, 11, 12, 13);
        System.out.println(date);
    }

    private static void right() {
        System.out.println("right");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 31, 11, 12, 13);
        System.out.println(calendar.getTime());
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        calendar2.set(2019, Calendar.DECEMBER, 31, 11, 12, 13);
        System.out.println(calendar2.getTime());

    }
}
