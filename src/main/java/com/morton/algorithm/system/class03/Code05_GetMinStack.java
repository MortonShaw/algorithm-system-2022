package com.morton.algorithm.system.class03;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本功能的基础上，在实现返回栈中最小元素的功能
 * 思路：两个栈，一个存放数据，一个存放最小值
 *
 * @author MortonShaw
 * @date 2021/10/8 22:43
 */
public class Code05_GetMinStack {

    public static class MyStack1 {
        private final Stack<Integer> stackData;
        private final Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum <= getMin()) {
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            Integer value = stackData.pop();
            if (value == getMin()) {
                stackMin.pop();
            }
            return value;
        }

        private int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return stackMin.peek();
        }

    }

    public static class MyStack2 {
        private final Stack<Integer> stackData;
        private final Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else {
                int min = getMin();
                if (newNum <= min) {
                    stackMin.push(newNum);
                } else {
                    stackMin.push(min);
                }
            }
            stackData.push(newNum);
        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        private int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return stackMin.peek();
        }

    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(3);
        System.out.println(myStack1.getMin());
        myStack1.push(4);
        System.out.println(myStack1.getMin());
        myStack1.push(1);
        System.out.println(myStack1.getMin());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.getMin());

        System.out.println("-----------------------------------");

        MyStack2 myStack2 = new MyStack2();
        myStack2.push(3);
        System.out.println(myStack2.getMin());
        myStack2.push(4);
        System.out.println(myStack2.getMin());
        myStack2.push(1);
        System.out.println(myStack2.getMin());
        System.out.println(myStack2.pop());
        System.out.println(myStack2.getMin());
    }


}
