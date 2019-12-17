package com.ruidge.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestEqual {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("111");
        list1.add("222");

        list2.add("222");
        list2.add("111");
//        list2.add("33");

        System.out.println(list1.equals(list2));

    }


}
