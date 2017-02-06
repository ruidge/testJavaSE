package com.ruidge.test;

import org.joda.time.DateTime;

import java.util.Date;

public class TestJoda {

    public static void main(String[] args) {

        java.util.Date juDate = new Date();
        DateTime dt = new DateTime(juDate);
        System.out.println(dt.toString());

        dt = dt.plusDays(30);
        dt = dt.plusHours(5);
        int month = dt.getMonthOfYear();
        int year = dt.getYear();
        int day = dt.getDayOfMonth();
        int hour = dt.getHourOfDay();
        int min = dt.getMinuteOfHour();
        System.out.println(year + "-" + month + "-" + day + "-" + hour + "-" + min);
    }
}
