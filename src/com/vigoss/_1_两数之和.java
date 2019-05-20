package com.vigoss;

import java.util.*;

/**
 * @author vigoss
 * @date 2019/5/10
 */
public class _1_两数之和 {
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> targetMap = new HashMap<>(nums.length);
    // 1.需要按数组下标顺序依次返回下标
    // 2.如果数组中存在相同的数字相加等于target

    //    for (int i = 0; i < nums.length; i++) {
    //      for (int j = 0; j < nums.length; j++) {
    //        if (nums[i] + nums[j] == target && i != j) {
    //          result[0] = j;
    //          result[1] = i;
    //          break;
    //        }
    //      }
    //    }

    for (int i = 0; i < nums.length; i++) {
      int cmp = target - nums[i];
      if (targetMap.containsKey(cmp)) {
        return new int[] {targetMap.get(cmp), i};
      }
      targetMap.put(nums[i], i);
    }

    return null;
  }

  public static void main(String[] args) {
    int[] ints = new int[] {2, 7,2, 11, 15};
    int[] ints1 = twoSum(ints, 4);
    System.out.println(Arrays.toString(ints1));
  }
}
