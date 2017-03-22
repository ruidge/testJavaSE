package com.ruidge.algorithm;


/**
 * Created by lenovo on 2017/2/22.
 */
public class TestNode {
    static class Node {
        public int data;// 数据域
        public Node next;// 指针域

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        // 打印反转前的链表
        Node index = head;
        while (null != index) {
            System.out.print(index.data + " ");
            index = index.next;
        }
        // 调用反转方法
        index = reverse1(head);
//        index = reverse2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != index) {
            System.out.print(index.data + " ");
            index = index.next;
        }

    }

    public static Node reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = reverse1(head.next);// 先反转后续节点head.getNext()
        head.next.next = head;// 将当前结点的指针域指向前一结点
        head.next = null;// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    public static Node reverse2(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        Node next = head.next;
        while (next != null) {
            Node tmp = next.next;
            next.next = current;

            current = next;
            next = tmp;
        }
        head.next = null;
        return current;
    }

}
