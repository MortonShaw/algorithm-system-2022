package com.morton.algorithm.system.class08_12;

public class Code03_IsBalanced {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        nodeA.left = nodeB;
        nodeB.left = nodeC;
        System.out.println(process(nodeA).isBalanced);
    }

    static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    static Info process(Node head) {
        if (head == null) {
            return new Info(true, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);

        boolean isBalanced = true;
        if (!left.isBalanced) {
            isBalanced = false;
        }
        if (!right.isBalanced) {
            isBalanced = false;
        }
        if (Math.abs(left.height - right.height) > 1) {
            isBalanced = false;
        }
        int height = Math.max(left.height, right.height) + 1;
        return new Info(isBalanced, height);
    }

}
