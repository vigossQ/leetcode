package com.vigoss;

import java.util.*;

/**
 * @author vigoss
 * @date 2019/5/10
 */
public class _1_两数之和 {
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    int[] ints = nums.clone();

    for (int i = 0; i < nums.length; i++) {
      for (int i1 = 0; i1 < ints.length; i1++) {
        if (nums[i] + ints[i1] == target && i != i1) {
          result[0] = i;
          result[1] = i1;
          break;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] ints = new int[] {3, 3};
    int[] ints1 = twoSum(ints, 6);
    System.out.println(Arrays.toString(ints1));
  }
}
