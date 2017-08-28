package com.ruidge.test;

import java.util.ArrayList;

public class TestIter {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(list.toString());
        list.set(1, "b");
        list.set(2, "c");
        System.out.println(list.toString());
        int i = 0, index = 0;
        for (; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("5")) {
                index = i;
                break;
            }
        }
        list.set(index, "index");
        System.out.println(list.toString());
    }
}
