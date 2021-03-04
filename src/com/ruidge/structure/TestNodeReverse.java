package com.ruidge.structure;


/**
 * Created by lenovo on 2017/2/22.
 */
public class TestNodeReverse {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node node = head;
        printNode(head);

//        node = reverse0(head);
//        node = reverse1(head);
//        node = reverse2(head);
        node = reverse3(head);

        System.out.println("\n**************************");
        printNode(node);

    }

    private static void printNode(Node head) {
        Node h = head;
        while (null != h) {
            System.out.print(h.data + " ");
            h = h.next;
        }
    }

    //迭代反转
    public static Node reverse0(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nLeft = null;
        Node nMid = head;
        Node nRight = head.next;

//        while (nRight != null) {
//            nMid.next = nLeft;
//            nLeft = nMid;
//            nMid = nRight;
//            nRight = nRight.next;
//        }
//        //最后一次指向前面
//        nMid.next = nLeft;
        while (true) {
            nMid.next = nLeft;
            if (nRight == null) {
                break;
            }
            nLeft = nMid;
            nMid = nRight;
            nRight = nRight.next;
        }
        return nMid;

    }

    //递归反转
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

    //创建一个新的nNew,然后遍历老的将每一个指向nNew,
    public static Node reverse2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //nNew一个新的头
        Node nNew = null;
        //遍历老的
        Node nIndex = head;
        while (nIndex != null) {
            Node next = nIndex.next;
            nIndex.next = nNew;
            nNew = nIndex;
            nIndex = next;
        }
        return nNew;
    }

    //直接反转
    public static Node reverse3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nIndex = head;
        Node next = nIndex.next;
        //将head的next置null
        head.next = null;
        while (next != null) {
            Node tmp = next.next;
            next.next = nIndex;
            nIndex = next;
            next = tmp;
        }
        return nIndex;
    }

}
