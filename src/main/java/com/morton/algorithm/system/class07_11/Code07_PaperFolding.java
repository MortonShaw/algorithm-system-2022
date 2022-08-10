package com.morton.algorithm.system.class07_11;

public class Code07_PaperFolding {

    static void process(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.print(down ? "凹" : "凸");
        process(i + 1, n, false);
    }

    public static void main(String[] args) {
        int n = 3;
        process(1, n, true);
    }

}
