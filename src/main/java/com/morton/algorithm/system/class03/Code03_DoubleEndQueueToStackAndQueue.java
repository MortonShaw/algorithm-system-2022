package com.morton.algorithm.system.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 双端队列
 * 栈和队列的实现
 *
 * @author MortonShaw
 * @date 2021/10/8 20:58
 */
public class Code03_DoubleEndQueueToStackAndQueue {

    /**
     * 双向链表
     *
     * @param <T>
     */
    public static class Node<T> {
        public T value;
        public Node<T> prev;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 双端队列
     *
     * @param <T>
     */
    public static class DoubleEndQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> curr = new Node<T>(value);
            if (head == null) {
                head = curr;
                tail = curr;
            } else {
                head.prev = curr;
                curr.next = head;
                head = curr;
            }
        }

        public void addFromTail(T value) {
            Node<T> curr = new Node<>(value);
            if (tail == null) {
                head = curr;
                tail = curr;
            } else {
                curr.prev = tail;
                tail.next = curr;
                tail = curr;
            }
        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> curr = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                // 断开两根线
                head.prev = null;
                curr.next = null;
            }
            return curr.value;
        }

        public T popFromTail() {
            if (tail == null) {
                return null;
            }
            Node<T> curr = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                // 断开两根线
                tail.next = null;
                curr.prev = null;
            }
            return curr.value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    /**
     * 栈结构，先进后出
     *
     * @param <T>
     */
    public static class MyStack<T> {
        private final DoubleEndQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    /**
     * 队列结构，先进先出
     *
     * @param <T>
     */
    public static class MyQueue<T> {
        private final DoubleEndQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int maxValue = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                double random = Math.random();
                int num = (int) (random * maxValue);
                if (stack.isEmpty()) {
                    stack.push(num);
                    myStack.push(num);
                } else {
                    if (random < 0.5) {
                        stack.push(num);
                        myStack.push(num);

                        queue.offer(num);
                        myQueue.push(num);
                    } else {
                        if (!isEqual(stack.pop(), myStack.pop())) {
                            System.out.println("stack oops!");
                        }

                        if (!isEqual(queue.poll(), myQueue.poll())) {
                            System.out.println("queue oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

}
