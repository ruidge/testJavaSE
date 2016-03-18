package com.ruidge.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    private static final String SPLIT = ".";

    public static void main( String[] args ) {
        // System.out.println(new Test().stRegionCode[0]);

        // String text = "回复@ruidge:asdf";
        // // String prefix = "回复@[\\w\\-]+:";
        // String prefix = "回复@[\\w\\-]+:";
        // System.out.println(text.startsWith(prefix));
        ////startWith不会匹配正则表达式
        // Pattern p = Pattern.compile(prefix);
        // Matcher m = p.matcher(text);
        // boolean b = m.find();
        // System.out.println(b);

        // split找不到返回"",不是返回全长度
        // String str = "a,bb,sdf,d,";
        // split demo
        // String str = "a,bb,sdf,d,";
        // if (!str.contains(SPLIT)) {
        // System.out.println(str);
        // } else {
        // for (String s : str.split(SPLIT)) {
        // System.out.println(s + "_");
        // }
        // }
        
//        String oriColor = "0xFF0000";//red
//        String desStr = oriColor.substring(2, 8);
//        int desInt = Integer.parseInt(desStr, 16);
//        System.out.println(Integer.toHexString(desInt));
//        
//        System.out.println("-------------------");
//        
//        //格式为8-4-4-4-12
//        for(int i = 0 ; i < 5 ; i++){
//            System.out.println(UUID.randomUUID().toString());
//        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list.size());
        //Exception
//        list.remove(0);
//        System.out.println(list.size());
        
    }
}
