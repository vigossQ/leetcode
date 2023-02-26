package com.vigoss.interview;

import java.util.HashMap;

/**
 * @author Reimu Hakurei
 * @date 2022/12/12 21:45
 */
public class SumZeroSubArray {

    public static int sumZeroSubArrayCount(int[] arr) {
        int max = 1_000_000_000;
        boolean allZeroFlag = true;
        // 限制判断
        for (int a : arr) {
            if (a >= max) {
                return -1;
            }
            if (a != 0) {
                allZeroFlag = false;
            }
        }
        // 全0判断
        if (allZeroFlag) {
            return -1;
        }
        // 前缀和为0的前缀和的个数
        HashMap<Integer, Integer> preSumCountMap = new HashMap<>();
        // 提前设置前缀和为0的个数是1
        preSumCountMap.put(0, 1);
        int preSum = 0;
        int count = 0;
        for (int a : arr) {
            preSum += a;
            if (preSumCountMap.containsKey(preSum)) {
                count += preSumCountMap.get(preSum);
            }
            preSumCountMap.put(preSum, preSumCountMap.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, -2, 0, 3, 0, 4, -7};
        int i = sumZeroSubArrayCount(arr);
        System.out.println(i);
    }
}
