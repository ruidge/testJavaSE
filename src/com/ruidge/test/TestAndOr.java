package com.ruidge.test;

public class TestAndOr {

    public static void main(String[] args) {

        //短路
        TestAndOr self = new TestAndOr();
        if (self.func1() && self.func2() && self.func3()) {
            System.out.println("&&&&&&&");
        }
        if (self.func1() || self.func2() || self.func3()) {
            System.out.println("|||||||");
        }
    }


    private boolean func1() {
        System.out.println("func1");
        return true;
    }

    private boolean func2() {
        System.out.println("func2");
        return false;
    }

    private boolean func3() {
        System.out.println("func3");
        return false;
    }

}
