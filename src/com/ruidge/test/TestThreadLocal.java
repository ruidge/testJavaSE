package com.ruidge.test;

public class TestThreadLocal {
    ThreadLocal<Integer> tlNum = new ThreadLocal<Integer>() {
                                   protected Integer initialValue() {
                                       return 0;
                                   }

                               };

    public int getNextNum() {
        Integer num = tlNum.get();// 取得下一个值
        tlNum.set(num + 1);// 设置下一个值
        return num;// 返回取得的值
    }

    private static class TestThreadRunnable implements Runnable {
        private TestThreadLocal tlt;

        public TestThreadRunnable(TestThreadLocal tlt) {
            this.tlt = tlt;
        }

        public void run() {
            int n = 3;
            for (int i = 0; i < n; i++) {
                System.out.println("线程【" + Thread.currentThread().getName() + "】-线程变量值【"
                        + tlt.getNextNum() + "】");
            }
        }
    }

    public static void main( String[] args ) {
        TestThreadLocal self = new TestThreadLocal();
        TestThreadRunnable tt1 = new TestThreadRunnable(self);
        TestThreadRunnable tt2 = new TestThreadRunnable(self);
        TestThreadRunnable tt3 = new TestThreadRunnable(self);
        Thread t1 = new Thread(tt1);
        Thread t2 = new Thread(tt2);
        Thread t3 = new Thread(tt3);
        t1.start();
        t2.start();
        t3.start();
    }
}
