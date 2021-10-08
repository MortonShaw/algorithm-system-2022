package com.morton.algorithm.system.class03;

/**
 * 删除给定的值
 *
 * @author MortonShaw
 * @date 2021/10/8 20:18
 */
public class Code02_DeleteGivenValue {

    /**
     * 单向链表
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 从链表中删除给定值
     *
     * @param head  头结点
     * @param value 给定值
     * @return 处理后的头结点
     */
    public static Node removeNode(Node head, int value) {
        // 首个结点
        Node first = null;
        // 前后结点，会进行偏移
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;

            if (head.value != value) {
                if (prev == null) {
                    first = head;
                } else {
                    prev.next = head;
                }
                prev = head;
            }

            head = next;
        }

        return first;
    }

    public static Node removeNode2(Node head, int value) {
        // head来到第一个不需要删除的位置
        while (head != null) {
            if (head.value == value) {
                head = head.next;
            } else {
                break;
            }
        }
        Node prev = head;
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node01 = new Node(2);
        Node node02 = new Node(2);
        Node node03 = new Node(2);
        node01.next = node02;
        node02.next = node03;
        System.out.println(removeNode2(node01, 2));
    }

}
