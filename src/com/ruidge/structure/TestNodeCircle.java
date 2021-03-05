package com.ruidge.structure;


/**
 * Created by lenovo on 2017/2/22.
 */
public class TestNodeCircle {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Node node = head;

        System.out.println(testCircle1(node));

        node8.next = node2;
        System.out.println(testCircle1(node));
    }

    public static boolean testCircle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node nStep1 = head;
        Node nStep2 = head.next;
        while (nStep1 != null && nStep2 != null &&
                nStep1.data != nStep2.data) {
            nStep1 = nStep1.next;
            nStep2 = nStep2.next.next;
        }

        if (nStep1 == null || nStep2 == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean testCircle1(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node index = head;
        while (index != null && index.extra == null) {
            index.extra = index.data;
            index = index.next;
        }

        if (index == null) {
            return false;
        } else {
            return true;
        }

    }

}
