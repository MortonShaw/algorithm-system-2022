package com.morton.algorithm.system.class08_12;

public class Code04_IsFull {

    static class Info {
        int height;
        int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    static Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);
        return new Info(Math.max(left.height, right.height) + 1, left.nodes + right.nodes + 1);
    }

    public static void main(String[] args) {
        Info info = process(null);
        if (info.nodes == 1 << info.height - 1) {

        }
    }

}
