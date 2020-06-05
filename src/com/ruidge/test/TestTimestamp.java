package com.ruidge.test;

import java.util.ArrayList;
import java.util.List;

public class TestTimestamp {

    public static void main(String[] args) {
        long ts = System.nanoTime();
        for (int i = 0; i < 10; i++) {
//            long ts = System.currentTimeMillis();
//            System.out.println(ts);
            long now = System.nanoTime();
            System.out.println(now - ts);
            ts = now;
        }
        System.out.println(Long.MAX_VALUE);
    }


}
