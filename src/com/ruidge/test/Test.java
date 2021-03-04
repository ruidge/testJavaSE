package com.ruidge.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {


//        System.out.println(1.0f / 3 * 3);
//        System.out.println(0.2f + 0.3f + 0.45f + 0.05f);
//        float priceCut = (float) mul(720000, 0.3f);
//
//        System.out.println(720000 * 0.3f);
//        System.out.println("" + priceCut);

        List<String> list = new ArrayList<String>();
//        list.addAll(null);
        list.add("11111111");
        list.add("222222");
        list.add("aaaaaa");
        list.add("ssss");
        System.out.println(list.size());


    }


    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(100, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

}
