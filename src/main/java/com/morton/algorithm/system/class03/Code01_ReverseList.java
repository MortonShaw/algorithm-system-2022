package com.morton.algorithm.system.class03;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表
 *
 * @author MortonShaw
 * @date 2021/10/7 22:33
 */
public class Code01_ReverseList {

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
     * 双向链表
     */
    public static class DoubleNode {
        public int value;
        public DoubleNode prev;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 反转单向链表
     * a -> b -> c -> null
     * c -> b -> a -> null
     *
     * @param head 翻转前的头结点
     * @return 反转后的头结点
     */
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 反转双向列表
     *
     * @param head 翻转前的头结点
     * @return 反转后的头结点
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 反转单向链表，校验方法
     *
     * @param head 翻转前的头结点
     * @return 反转后的头结点
     */
    public static Node testReverseList(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(list.size() - 1);
    }

    /**
     * 反转双向链表，校验方法
     *
     * @param head 翻转前的头结点
     * @return 反转后的头结点
     */
    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        List<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).prev = list.get(i).next;
            list.get(i).next = list.get(i - 1);
        }
        return list.get(list.size() - 1);
    }

    /**
     * 生成单向链表
     *
     * @param maxLength 最大长度
     * @param maxValue  最大值
     * @return 单向链表的首节点
     */
    public static Node generateRandomLinkedList(int maxLength, int maxValue) {
        int size = (int) (Math.random() * (maxLength + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (maxValue + 1)));
        Node prev = head;
        while (size != 0) {
            Node current = new Node((int) (Math.random() * (maxValue + 1)));
            prev.next = current;
            prev = current;
            size--;
        }
        return head;
    }

    /**
     * 生成双向链表
     *
     * @param maxLength 最大长度
     * @param maxValue  最大值
     * @return 单向链表的首节点
     */
    public static DoubleNode generateRandomDoubleList(int maxLength, int maxValue) {
        int size = (int) (Math.random() * (maxLength + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (maxValue + 1)));
        DoubleNode prev = head;
        while (size != 0) {
            DoubleNode current = new DoubleNode((int) (Math.random() * (maxValue + 1)));
            prev.next = current;
            current.prev = prev;
            prev = current;
            size--;
        }
        return head;
    }

}
