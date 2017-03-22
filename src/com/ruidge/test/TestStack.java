package com.ruidge.test;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by lenovo on 2017/2/22.
 */
public class TestStack {

    public static void main(String[] args) {
        testStack();
        testQueue();
    }

    private static void testQueue() {
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i + "");
        }

        while (queue.size() > 0) {
            System.out.print(queue.poll() + " ");
        }
        System.out.print("\n ");
    }

    private static void testStack() {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i + "");
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
        System.out.print("\n ");
    }

}
