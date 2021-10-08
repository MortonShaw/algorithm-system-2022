package com.morton.algorithm.system.class03;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表
 * 思路：指针转向
 *
 * @author MortonShaw
 * @date 2021/10/7 22:33
 */
public class Code01_ReverseLinkedList {

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
    public static Node reverseLinkedList(Node head) {
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
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
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
    public static Node testReverseLinkedList(Node head) {
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
    public static DoubleNode testReverseDoubleLinkedList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        List<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        list.get(0).prev = list.get(0).next;
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
    public static DoubleNode generateRandomDoubleLinkedList(int maxLength, int maxValue) {
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

    /**
     * 获得单向链表原始顺序
     *
     * @param head 单向链表头结点
     * @return 原始顺序的集合
     */
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * 校验单向链表是否反转成功
     *
     * @param origin 原始顺序
     * @param head   单向链表头结点
     * @return 是否反转成功 true | false
     */
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 获得双向链表原始顺序
     *
     * @param head 双向链表头结点
     * @return 原始顺序的集合
     */
    public static List<Integer> getDoubleLinkedListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * 校验双向链表是否反转成功
     *
     * @param origin 原始顺序
     * @param head   双向链表头结点
     * @return 是否反转成功 true | false
     */
    public static boolean checkDoubleLinkedListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (Integer integer : origin) {
            if (!integer.equals(end.value)) {
                return false;
            }
            end = end.prev;
        }
        return true;
    }

    /**
     * 测试主程序
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        int maxLength = 50;
        int maxValue = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            Node node = generateRandomLinkedList(maxLength, maxValue);
            List<Integer> linkedListOriginOrder = getLinkedListOriginOrder(node);
//            Node reverseNode = reverseLinkedList(node);
            Node reverseNode = testReverseLinkedList(node);
            if (!checkLinkedListReverse(linkedListOriginOrder, reverseNode)) {
                System.out.println("linked list oops!");
            }

            DoubleNode doubleNode = generateRandomDoubleLinkedList(maxLength, maxValue);
            List<Integer> doubleLinkedListOriginOrder = getDoubleLinkedListOriginOrder(doubleNode);
//            DoubleNode reverseDoubleList = reverseDoubleLinkedList(doubleNode);
            DoubleNode reverseDoubleList = testReverseDoubleLinkedList(doubleNode);
            if (!checkDoubleLinkedListReverse(doubleLinkedListOriginOrder, reverseDoubleList)) {
                System.out.println("double linked list oops!");
            }
        }
        System.out.println("test end!");
    }

}
