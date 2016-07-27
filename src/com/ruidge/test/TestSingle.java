package com.ruidge.test;

public class TestSingle {

    public static void main(String[] args) {
        SingleA.getInstance("haha").say();
    }


}

class Single {
    private static Single instance;

    private String name;

    protected Single(String name) {
        this.name = name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static Single getInstance(String name) {
        if (instance == null) {
            instance = new Single(name);
        }
        instance.setName(name);
        return instance;
    }

    public void say() {
        System.out.println(name);
    }

}

class SingleA extends Single {

    protected SingleA(String name) {
        super(name);
    }
}