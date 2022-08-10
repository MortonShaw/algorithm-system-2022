package com.morton.algorithm.system.class07_11;

import java.util.*;

public class Code05_TreeMaxWidth {

    public static void main(String[] args) {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        node1.setLeft(node2);
        node1.setRight(node3);
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        Node node7 = new Node("7");
        Node node8 = new Node("8");
        node5.setLeft(node7);
        node6.setRight(node8);

        System.out.println(maxWidthNoMap(node1));
        System.out.println(maxWidthWithMap(node1));
    }

    static int maxWidthWithMap(Node head) {
        int level = 1;
        Map<Integer, Integer> map = new HashMap<>();
        handle(head, level, map);
        Collection<Integer> values = map.values();
        int max = 0;
        for (Integer i : values) {
            max = Math.max(max, i);
        }
        return max;
    }

    static void handle(Node node, Integer level, Map<Integer, Integer> map) {
        if (map.containsKey(level)) {
            map.put(level, map.get(level) + 1);
        } else {
            map.put(level, 1);
        }
        if (node.getLeft() != null) {
            handle(node.getLeft(), level + 1, map);
        }
        if (node.getRight() != null) {
            handle(node.getRight(), level + 1, map);
        }
    }

    static int maxWidthNoMap(Node head) {
        // 最大宽度
        int max = 0;
        // 当前层最后节点
        Node curEnd = null;
        // 下一层最后节点
        Node nextEnd = null;
        // 当前层宽度
        int cur = 0;
        if (head == null) {
            return max;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        curEnd = head;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
                nextEnd = node.getLeft();
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
                nextEnd = node.getRight();
            }
            cur++;
            if (curEnd.getValue().equals(node.getValue())) {
                max = Math.max(cur, max);
                curEnd = nextEnd;
                nextEnd = null;
                cur = 0;
            }
        }
        return max;
    }

}
