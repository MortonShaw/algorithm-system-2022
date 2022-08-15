package com.morton.algorithm.system.class08_12;

public class Code08_MaxDistance {

    static class Info {
        int distance;
        int height;

        public Info(int distance, int height) {
            this.distance = distance;
            this.height = height;
        }
    }

    static Info process(Node head) {
        if (head == null) {
            return new Info(0, 0);
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int height = Math.max(left.height, right.height) + 1;
        int distance = Math.max(Math.max(left.distance, right.distance), left.height + right.height + 1);
        return new Info(distance, height);
    }

}
