package com.ruidge.test;

public class TestInteger {

    /**
     * 值传递 测试
     * 包装类的值都是final 不可变的，对于++b 或者b++ ，只是新创建了一个对象，然后把引用传给了原对象句柄，
     * 在函数中操作，只是形参的临时句柄改变了指向，实参的句柄还是指向原来的对象。所以实参的值不会改变。
     * @param args
     */
    public static void main(String[] args) {
        int i1 = 1000;
        Integer i2 = new Integer(1000);

//        System.out.println(i1 + " - " + i2);
        fun1(i1);
        fun2(i2);
//        System.out.println(i1 + " - " + i2);


        String str = new String("ada");
        char[] ch = {'a', 'b', 'c'};

        change(str, ch);

        System.out.println(str);
        System.out.println(ch);

    }

    public static void change(String str, char ch[]) {
        str = "ada 111";
        ch[0] = 'd';
    }

    static void fun1(int i) {
        for (int a = 0; a < 5; a++) {
            i = i + 1;
        }
    }

    static void fun2(Integer i) {
        for (int a = 0; a < 5; a++) {
            i = i + 1;
        }
    }

}
