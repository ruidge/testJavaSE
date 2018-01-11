package com.ruidge.test;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestSplit {


    static String s1 = "\tmap_Kd eye1.png";
    static String s2 = "map_Kd sucai.png";


    public static void main(String[] args) {
        String[] temp1 = s1.split("[ ]+");
        System.out.println(temp1.length +" : "+Arrays.toString(temp1));
        String[] temp2 = s2.split("[ ]+");
        System.out.println(temp2.length + " : " + Arrays.toString(temp2));

    }


}
