package com.morton.algorithm.system.class07_11;

import java.util.ArrayList;
import java.util.List;

public class Code03_EncodeNaryTreeToBinaryTree {

    static class Node {
        String value;
        List<Node> children;

        public Node() {

        }

        public Node(String value) {
            this.value = value;
        }

        public Node(String value, List<Node> children) {
            this.value = value;
            this.children = children;
        }
    }

    static class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }
    }

    class Codec {
        public TreeNode encode(Node node) {
            if (node == null) {
                return null;
            }
            TreeNode head = new TreeNode(node.value);
            head.left = en(node.children);
            return head;
        }

        private TreeNode en(List<Node> children) {
            TreeNode head = null;
            TreeNode cur = null;
            for (Node child : children) {
                TreeNode treeNode = new TreeNode(child.value);
                if (head == null) {
                    head = treeNode;
                } else {
                    cur.right = treeNode;
                }
                cur = treeNode;
                cur.left = en(child.children);
            }
            return head;
        }

        public Node decode(TreeNode treeNode) {
            if (treeNode == null) {
                return null;
            }
            return new Node(treeNode.value, de(treeNode.left));
        }

        private List<Node> de(TreeNode left) {
            List<Node> children = new ArrayList<>();
            while (left!= null) {
                children.add(new Node(left.value, de(left.left)));
                left = left.right;
            }
            return children;
        }

    }

}
