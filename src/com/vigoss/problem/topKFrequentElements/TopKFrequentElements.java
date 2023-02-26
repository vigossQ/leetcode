package com.vigoss.problem.topKFrequentElements;

import java.util.*;

/**
 * @author vigoss
 * <p>
 * _347_前K个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @date 2019/11/22
 */
@SuppressWarnings("unchecked")
public class TopKFrequentElements {


    public static void main(String[] args) {
        //
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> integers = topKFrequent(nums, k);
        System.out.println(integers);
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        // 存储每个整数的出现次数
        Map<Integer, Integer> counts = new HashMap<>(nums.length);
        for (int num : nums) { // O(n)
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entrySet = counts.entrySet();
        // 找轴点

        return result;
    }

    /**
     * 桶排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent4(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        // 存储每个整数的出现次数
        Map<Integer, Integer> counts = new HashMap<>(nums.length);
        for (int num : nums) { // O(n)
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entrySet = counts.entrySet();
        List<Integer>[] buckets = new List[nums.length + 1];
        int maxNo = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) { // O(m)
            Integer no = entry.getValue();
            List<Integer> bucket = buckets[no];
            if (null == bucket) {
                bucket = new LinkedList<>();
                buckets[no] = bucket;
                maxNo = Math.max(maxNo, no);
            }
            bucket.add(entry.getKey());
        }

        for (int i = maxNo; i > 0 && result.size() < k; i--) { // O(n)
            if (null == buckets[i]) {
                continue;
            }
            result.addAll(buckets[i]);
        }

        return result;
    }

    /**
     * 优先级队列2
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent3(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        // 存储每个整数的出现次数
        Map<Integer, Integer> counts = new HashMap<>(nums.length);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // java原生的优先级队列, 其实是一个最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(counts::get));
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else if (entry.getValue() > counts.get(queue.peek())) {
                queue.poll();
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            result.add(0, queue.poll());
        }

        return result;
    }

    /**
     * 优先级队列1
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
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

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            result.add(0, entry.getKey());
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
        Map.Entry<Integer, Integer>[] entries = entrySet.toArray(new Map.Entry[counts.size()]); // O(m)
        Arrays.sort(entries, (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e2.getValue() - e1.getValue()); // O(mlogm)
        for (int i = 0; i < k; i++) {
            result.add(entries[i].getKey());
        }

        return result;
    }
}
