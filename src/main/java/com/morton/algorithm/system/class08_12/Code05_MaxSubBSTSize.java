package com.morton.algorithm.system.class08_12;

public class Code05_MaxSubBSTSize {

    /*
     * 计算是二叉查找树的子树的最大节点个数
     *
     * 二叉查找树子树的最大节点个数
     * max
     * min
     * size
     *
     */

    static class Info {
        int maxSubBSTSize;
        int maxValue;
        int minValue;
        int subBSTSize;

        public Info(int maxSubBSTSize, int maxValue, int minValue, int subBSTSize) {
            this.maxSubBSTSize = maxSubBSTSize;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.subBSTSize = subBSTSize;
        }
    }

    static Info process(Node head) {
        if (head == null) {
            return null;
        }

        Info left = process(head.left);
        Info right = process(head.right);

        int maxSubBSTSize;
        int maxValue = head.value;
        int minValue = head.value;
        int subBSTSize = 1;
        int p1 = -1;
        if (left != null) {
            maxValue = Math.max(maxValue, left.maxValue);
            minValue = Math.min(minValue, left.minValue);
            subBSTSize += left.maxSubBSTSize;
            p1 = left.maxSubBSTSize;
        }
        int p2 = -1;
        if (right != null) {
            maxValue = Math.max(maxValue, right.maxValue);
            minValue = Math.min(minValue, right.minValue);
            subBSTSize += right.subBSTSize;
            p2 = right.maxSubBSTSize;
        }

        int p3 = -1;
        // 左右子树都是二叉查找树
        boolean leftIsBST = left == null || left.maxSubBSTSize == left.subBSTSize;
        boolean rightIsBST = right == null || right.maxSubBSTSize == right.subBSTSize;
        if (leftIsBST && rightIsBST) {
            // 值合适
            boolean leftOk = left == null || left.maxValue < head.value;
            boolean rightOk = right == null || right.minValue > head.value;
            if (leftOk && rightOk) {
                int leftSize = left == null ? 0 : left.subBSTSize;
                int rightSize = right == null ? 0 : right.subBSTSize;
                p3 = leftSize + rightSize + 1;
            }
        }

        return new Info(Math.max(p1, Math.max(p2, p3)), maxValue, minValue, subBSTSize);
    }
}
