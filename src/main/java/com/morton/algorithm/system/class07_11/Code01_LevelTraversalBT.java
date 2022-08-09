package com.morton.algorithm.system.class07_11;

import java.util.LinkedList;
import java.util.Queue;

public class Code01_LevelTraversalBT {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        nodeC.setLeft(nodeF);
        nodeC.setRight(nodeG);

        levelPrint(nodeA);
    }

    static void levelPrint(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.getValue());
            if (n.getLeft() != null) {
                queue.add(n.getLeft());
            }
            if (n.getRight() != null) {
                queue.add(n.getRight());
            }
        }
    }

}
