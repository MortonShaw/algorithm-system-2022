package com.morton.algorithm.system.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列模拟栈
 *
 * @author MortonShaw
 * @date 2021/10/10 11:46
 */
public class Code07_TwoQueueImplementStack {

    private static class TwoQueueStack<E> {
        private Queue<E> pushQueue;
        private Queue<E> popQueue;

        public TwoQueueStack() {
            pushQueue = new LinkedList<>();
            popQueue = new LinkedList<>();
        }

        private void push(E e) {
            pushQueue.offer(e);
        }

        private E pop() {
            while (pushQueue.size() > 1) {
                popQueue.offer(pushQueue.poll());
            }
            E head = pushQueue.poll();
            if (head == null) {
                return null;
            }
            Queue<E> temp = popQueue;
            popQueue = pushQueue;
            pushQueue = temp;
            return head;
        }

        private E peek() {
            while (pushQueue.size() > 1) {
                popQueue.offer(pushQueue.poll());
            }
            E head = pushQueue.poll();
            if (head == null) {
                return null;
            }
            Queue<E> temp = popQueue;
            popQueue = pushQueue;
            pushQueue = temp;

            pushQueue.offer(head);
            return head;
        }

        private boolean isEmpty() {
            return pushQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        TwoQueueStack<Integer> twoQueueStack = new TwoQueueStack<>();
        twoQueueStack.push(1);
        twoQueueStack.push(2);
        twoQueueStack.push(3);
        System.out.println(twoQueueStack.peek());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.peek());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.peek());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.peek());
        System.out.println(twoQueueStack.pop());
    }

}
