package com.morton.algorithm.system.class03;

/**
 * @author MortonShaw
 * @date 2021/10/10 21:20
 */
public class Code08_GetMax {

    private static int getMax(int[] array, int left, int right) {
        // 递归的关键：退出条件（base case）
        if (left == right) {
            return array[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftValue = getMax(array, left, mid);
        int rightValue = getMax(array, mid + 1, right);
        return Math.max(leftValue, rightValue);
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 3};
        if (array.length == 0) {
            return;
        }
        System.out.println(getMax(array, 0, array.length - 1));
    }

}
