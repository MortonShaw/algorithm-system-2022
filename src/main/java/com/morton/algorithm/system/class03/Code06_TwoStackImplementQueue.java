package com.morton.algorithm.system.class03;

import java.util.Stack;

/**
 * 两个栈，模拟堆
 *
 * @author MortonShaw
 * @date 2021/10/10 11:29
 */
public class Code06_TwoStackImplementQueue {

    public static class TwoStacksQueue {
        public Stack<Integer> pushStack;
        public Stack<Integer> popStack;

        public TwoStacksQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        /**
         * push栈向pop栈倒入数据
         * 1.前提是pop栈必须为空
         * 2.需要一次性倒完
         */
        private void pushToPop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        public void offer(int value) {
            pushStack.push(value);
        }

        public Integer poll() {
            if (popStack.isEmpty() && pushStack.isEmpty()) {
                return null;
            }
            pushToPop();
            return popStack.pop();
        }

        public Integer peek() {
            if (popStack.isEmpty() && pushStack.isEmpty()) {
                return null;
            }
            pushToPop();
            return popStack.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }

}
