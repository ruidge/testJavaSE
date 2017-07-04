package com.ruidge.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 9, 0, 0);
        long time9 = calendar.getTime().getTime();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 18, 0, 0);
        long time18 = calendar.getTime().getTime();
        System.out.println(formatData(time9));
        System.out.println(formatData(time18));

    }


    private static String formatData(long time) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formater.format(new Date(time));
    }

}
