package com.morton.algorithm.system.class08_12;

import com.morton.algorithm.system.class07_11.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Code01_IsCBT {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        nodeA.setLeft(nodeB);
        nodeB.setLeft(nodeC);

        System.out.println(isCBT(nodeA));
        System.out.println(isCBT2(nodeA));
    }

    static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node left = null;
        Node right = null;
        boolean self = false;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            right = node.getRight();
            left = node.getLeft();
            // 不满足完全二叉树的条件
            // 1、有右节点无左节点
            // 2、已经出现了子节点不满的节点，后续又出现了非叶子结点
            if (right != null && left == null || self && (left != null || right != null)) {
                return false;
            } else {
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                if (left == null || right == null) {
                    self = true;
                }
            }
        }

        return true;
    }

    static boolean isCBT2(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                break;
            }
            // 子节点为空时全部加入，包括空节点
            if (node.getLeft() != null || node.getRight() != null) {
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }

        // 发现空节点后，后面不应有非空节点
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                return false;
            }
        }

        return true;
    }

}
