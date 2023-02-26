package com.vigoss.interview;

import java.util.Arrays;

public class ReverseCoin {

    public static int reverseCoin(int[] A) {
        int[] B = new int[A.length];
        int min1 = 0;
        int min2 = 0;
        for (int i = 0; i < A.length; i++) {
            B[i] = i % 2;
        }
        System.out.println(Arrays.toString(B));

        for (int i = 0; i < A.length; i++) {
            min1 += A[i] ^ B[i];
        }

        for (int i = 0; i < A.length; i++) {
            B[i] = i % 2 == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(B));
        for (int i = 0; i < A.length; i++) {
            min2 += A[i] ^ B[i];
        }

        return Math.min(min1, min2);
    }

    public static void main(String[] args) {
        int size = 5;
        long range = 1;
//        int[] ints = CodeUtil.generateRandomIntArr(size, range);
        int[] ints = new int[]{1, 0, 1, 0, 1};
        System.out.println(Arrays.toString(ints));
        int i = reverseCoin(ints);
        System.out.println(i);
    }
}
