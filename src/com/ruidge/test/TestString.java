package com.ruidge.test;

public class TestString {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        String string = "abc";
        changeString(string);
        System.out.println(string);
        
    }

    static void changeString(String str){
        str = "改变后的字符串";
    }
    
}
