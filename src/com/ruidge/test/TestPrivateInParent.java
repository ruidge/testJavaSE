package com.ruidge.test;

public class TestPrivateInParent {
    public static void main( String[] args ) {
        Father f = new Father();
        f.print();
        Father f1 = new child();
        f1.print();
        child c = new child();
        c.print();
    }

}

class Father {
    protected int a = 1;
    protected int b = 2;

    public void print() {
        System.out.println(function());
    }

    private int function() {
        return a + b;
    }

}

//结论,子类不可以覆盖父类的私有变量
class child extends Father{
    protected int a = 100;
}