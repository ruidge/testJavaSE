package com.ruidge.test;


public class TestLambda {

    public static void main(String[] args) {
        execute((s) -> System.out.println("hello " + s), "ruidge");

    }

    private static void execute(WorkerInterface worker, String name) {
        worker.doSomeWork(name);
    }

    //只能有一个
    @FunctionalInterface
    public interface WorkerInterface {

        void doSomeWork(String str);

    }
}
