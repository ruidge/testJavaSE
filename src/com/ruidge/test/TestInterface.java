package com.ruidge.test;


interface Face {
    //java8 接口方法的默认实现
    default void HelloWorld() {
        System.out.println("Face : Default Hello World ");
    }
}

class FaceImpl implements Face {

}

public class TestInterface {
    public static void main(String[] args) {
        FaceImpl face = new FaceImpl();
        face.HelloWorld();
    }

}
