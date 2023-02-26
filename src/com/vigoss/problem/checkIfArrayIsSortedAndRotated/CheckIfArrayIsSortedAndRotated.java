package com.vigoss.problem.checkIfArrayIsSortedAndRotated;

import java.util.Arrays;

/**
 * @author Reimu Hakurei
 * https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
 */
public class CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
//        int[] ints = CodeUtil.generateRandomIntArr(5, 10);
        int[] ints = {3, 3, 4, 5, 1, 2, 3};
        System.out.println(Arrays.toString(ints));
        boolean check = check(ints);
        System.out.println(check);
    }

    public static boolean check(int[] nums) {
        // 先判断是否单调增
        boolean res = true;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (!res) {
                    return false;
                }
                res = false;
                System.out.println("非单调增");
                max = nums[i - 1];
                continue;
            }
            if (max != nums[0] && nums[i] > max) {
                System.out.println("死刑");
                return false;
            }
        }
        if (!res && nums[0] >= nums[nums.length - 1]) {
            res = true;
            System.out.println("可以");
        }
        return res;
    }
}
