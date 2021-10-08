package com.morton.algorithm.system.class03;

/**
 * 数组实现栈和队列
 *
 * @author MortonShaw
 * @date 2021/10/8 22:21
 */
public class Code04_RingArray {

    /**
     * 栈
     */
    public static class MyStack {
        private final Integer[] array;
        private int pushIndex;
        private final int limit;

        public MyStack(int limit) {
            array = new Integer[limit];
            pushIndex = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (pushIndex == limit) {
                throw new RuntimeException("队列满了，不能再加了！");
            }
            array[pushIndex] = value;
            pushIndex++;
        }

        public int pop() {
            if (pushIndex == 0) {
                throw new RuntimeException("队列空了，不能再拿了！");
            }
            int value = array[pushIndex];
            array[pushIndex] = null;
            pushIndex--;
            return value;
        }

        public boolean isEmpty() {
            return pushIndex == 0;
        }

    }

    /**
     * 队列
     * 理解size的使用
     */
    public static class MyQueue {
        private final Integer[] array;
        private int pushIndex;
        private int popIndex;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            array = new Integer[limit];
            pushIndex = 0;
            popIndex = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了！");
            }
            size++;
            array[pushIndex] = value;
            pushIndex = nextIndex(pushIndex);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了！");
            }
            size--;
            int value = array[popIndex];
            array[popIndex] = null;
            popIndex = nextIndex(popIndex);
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int pushIndex) {
            return pushIndex == limit - 1 ? 0 : pushIndex + 1;
        }

    }

}
