package com.vigoss;

import java.util.*;

/**
 * @author hong.chang
 * @date 2019/11/22
 */
@SuppressWarnings("unchecked")
public class _347_前K个高频元素 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 存储每个整数的出现次数
        Map<Integer, Integer> counts = new HashMap<>(nums.length);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // java原生的优先级队列, 其实是一个最小堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (entry.getValue() > queue.peek().getValue()) {
                queue.poll();
                queue.offer(entry);
            }
        }

        for (Map.Entry<Integer, Integer> entry : queue) {
            result.add(entry.getKey());
        }

        return result;
    }

    /**
     * 对entries全排序解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 存储每个整数的出现次数
        Map<Integer, Integer> counts = new HashMap<>(nums.length);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entrySet = counts.entrySet();
        Map.Entry<Integer, Integer>[] entries = entrySet.toArray(new Map.Entry[counts.size()]);
        Arrays.sort(entries, (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e2.getValue() - e1.getValue());
        for (int i = 0; i < k; i++) {
            result.add(entries[i].getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        //
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> integers = topKFrequent(nums, k);
        System.out.println(integers);
    }
}
