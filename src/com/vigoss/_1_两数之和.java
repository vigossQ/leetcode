package com.vigoss;

import java.util.*;

/**
 * @author vigoss
 * @date 2019/5/10
 */
public class _1_两数之和 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * <p>你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int cmp = target - nums[i];
            if (targetMap.containsKey(cmp)) {
                return new int[]{targetMap.get(cmp), i};
            }
            targetMap.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 7, 2, 11, 15};
        int[] ints1 = twoSum(ints, 4);
        System.out.println(Arrays.toString(ints1));
    }
}
