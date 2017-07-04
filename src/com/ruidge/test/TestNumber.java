package com.ruidge.test;

import java.text.NumberFormat;

public class TestNumber {

    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(4);
        nf.setMinimumFractionDigits(1);
        System.out.println(nf.format(10000.984644d));

    }
}
