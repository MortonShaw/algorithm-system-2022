package com.morton.algorithm.system.class07_11;

import java.util.LinkedList;
import java.util.Queue;

public class Code02_SeriallizeAndReconstructTree {

    public static void main(String[] args) {
        Node nodeA = new Node("a");
        Node nodeB = new Node("b");
        Node nodeC = new Node("c");
        nodeA.setLeft(nodeB);
        nodeB.setRight(nodeC);

        Queue<String> queue = preSerial(nodeA);
//        while (!queue.isEmpty()) {
//            System.out.print(queue.poll());
//        }

        Node node = buildByPreQueue(queue);
        System.out.println("-------------------------");

        Queue<String> queue1 = levelSerial(nodeA);
//        while (!queue1.isEmpty()) {
//            System.out.print(queue1.poll());
//        }

        Node node1 = buildByLevelQueue(queue1);
        System.out.println("-------------------------");
    }

    static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add("#");
        } else {
            ans.add(head.getValue());
            pres(head.getLeft(), ans);
            pres(head.getRight(), ans);
        }
    }

    static Node buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preb(preList);
    }

    static Node preb(Queue<String> preList) {
        String value = preList.poll();
        if ("#".equals(value)) {
            return null;
        }
        Node node = new Node(value);
        // 有点困惑
        node.setLeft(preb(preList));
        node.setRight(preb(preList));
        return node;
    }

    static Queue<String> levelSerial(Node node) {
        Queue<String> ans = new LinkedList<>();
        if (node == null) {
            ans.add("#");
        } else {
            ans.add(node.getValue());
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.getLeft() != null) {
                    queue.add(cur.getLeft());
                    ans.add(cur.getLeft().getValue());
                } else {
                    ans.add("#");
                }
                if (cur.getRight() != null) {
                    queue.add(cur.getRight());
                    ans.add(cur.getRight().getValue());
                } else {
                    ans.add("#");
                }
            }
        }

        return ans;
    }

    static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.isEmpty()) {
            return null;
        }
        Node head = generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        Node node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.setLeft(generateNode(levelList.poll()));
            node.setRight(generateNode(levelList.poll()));
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return head;
    }

    static Node generateNode(String node) {
        if ("#".equals(node)) {
            return null;
        } else {
            return new Node(node);
        }
    }

}
