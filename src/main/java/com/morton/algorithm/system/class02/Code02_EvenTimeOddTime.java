package com.morton.algorithm.system.class02;

/**
 * @author MortonShaw
 * @date 2021/10/10 22:19
 */
public class Code02_EvenTimeOddTime {

    /**
     * arr中，只有一种数，出现奇数次，其他都为偶数次
     * 空间复杂度要求为 O(1)
     * 思路：偶数次的数异或为0
     *
     * @param array 数组
     */
    private static void printOddTimeNum1(int[] array) {
        int xor = 0;
        for (int i : array) {
            xor ^= i;
        }
        System.out.println(xor);
    }

    /**
     * arr中，有两种数，出现奇数次，其他都为偶数次
     * 空间复杂度要求为 O(1)
     *
     * @param array 数组
     */
    private static void printOddTimeNum2(int[] array) {
        // xor = a ^ b
        int xor = 0;
        for (int i : array) {
            xor ^= i;
        }

        // a和b是两种数
        // xor != 0
        // xor 最右侧的1提取出来
        // xor      00110010110111000
        // rightOne 00000000000001000
        int rightOne = xor & (-xor);

        int onlyOne = 0;
        for (int i : array) {
            if ((i & rightOne) == 0) {
                onlyOne ^= i;
            }
        }
        System.out.println(onlyOne + " " + (xor ^ onlyOne));
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
        System.out.println("-------------------------");

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimeNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimeNum2(arr2);
    }

}
