package com.morton.algorithm.system.class08_12;

public class Code02_IsBST {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Info {
        boolean isBST;
        int max;
        int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    static Info process(Node node) {
        if (node == null) {
            return null;
        }
        Info left = process(node.left);
        Info right = process(node.right);
        boolean isBST = true;
        int max = node.value;
        int min = node.value;
        if (left != null) {
            if (!left.isBST) {
                isBST = false;
            }
            if (left.max >= node.value) {
                isBST = false;
            }
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
        }
        if (right != null) {
            if (!right.isBST) {
                isBST = false;
            }
            if (right.min <= node.value) {
                isBST = false;
            }
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
        }
        return new Info(isBST, max, min);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(process(node2).isBST);
    }

}
