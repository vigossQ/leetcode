package com.vigoss.util;

import java.util.Arrays;

/**
 * 代码工具
 *
 * @author Reimu Hakurei
 */
public class CodeUtil {

    public static final char[] LETTER = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * 生成随机int数组
     *
     * @param size  数组大小
     * @param range 数值范围
     * @return 随机int数组
     */
    public static int[] generateRandomIntArr(int size, long range) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = (int) (Math.random() * range);
        }
        return result;
    }

    /**
     * 生成随机纯字母字符串
     *
     * @param length 生成字符串长度大小
     * @return 随机纯字母字符串
     */
    public static String generateRandomLetterString(int length) {
        char[] chars = new char[length];
        int[] ints = generateRandomIntArr(length, LETTER.length);
        for (int i = 0; i < length; i++) {
            chars[i] = LETTER[ints[i]];
        }
        return new String(chars);
    }

    /**
     * 交换数组两个索引位置的数
     *
     * @param arr   array
     * @param left  left index
     * @param right right index
     */
    public static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    /**
     * 生成随机链表
     *
     * @param size  链表长度
     * @param range 数值范围
     * @return 随机链表头结点
     */
    public static ListNode generateRandomListNode(int size, long range) {
        ListNode head = new ListNode((int) (Math.random() * range));
        ListNode cur = head;
        for (int i = 0; i < size - 1; i++) {
            cur.next = new ListNode((int) (Math.random() * range));
            cur = cur.next;
        }
        return head;
    }

    /**
     * 快排
     *
     * @param arr array
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 把目标值放到最右侧
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            // 得到相等区域的左右边界
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        // 相等区域的左右边界
        int ll = l;
        int rr = r;
        // 循环条件：当前指针小于相等区域右边界
        while (l < rr) {
            // 如果当前值小于目标值（目标值在最右侧），相等区域左边界右移，指针右移
            if (arr[l] < arr[r]) {
                swap(arr, l++, ll++);
            }
            // 如果当前值大于目标值，相等区域右边界左移然后与目标值交换
            else if (arr[l] > arr[r]) {
                swap(arr, --rr, l);
            }
            // 相等，指针右移
            else {
                l++;
            }
        }
        // 最后交换相等区域右边界和目标值
        swap(arr, rr, r);
        return new int[]{ll, rr};
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 堆化（大根堆）
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        System.out.println("大根堆：" + Arrays.toString(arr));
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        // 进行减
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
//        if (arr[0] > arr[1]) {
//            swap(arr, 0, 1);
//        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        if (index * 2 + 1 >= heapSize) {
            return;
        }
        int maxChildIndex = arr[index * 2 + 1] >= arr[index * 2 + 2] ? index * 2 + 1 : index * 2 + 2;
        while (arr[maxChildIndex] > arr[index]) {
            swap(arr, maxChildIndex, index);
            heapify(arr, maxChildIndex, heapSize);
        }
    }

    /**
     * 打印链表
     *
     * @param head 链表头结点
     * @return 打印字符串
     */
    public static String printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val).append(", ");
            head = head.next;
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode reverse(ListNode left, ListNode right) {
        ListNode prev = null;
        ListNode cur = left;
        while (cur != null && cur != right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode lprev = null;
        ListNode start = null;
        ListNode end = null;
        ListNode cur = head;
        int count = 1;
        while (count < right) {
            if (count == left) {
                lprev = prev;
                start = cur;
            }
            prev = cur;
            cur = cur.next;
            count++;
        }

        end = cur.next;

        ListNode reverse = reverse(start, end);
        if (lprev != null) {
            lprev.next = reverse;
        } else {
            head = reverse;
        }
        start.next = end;

        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode cur = head;
        ListNode left = head;
        ListNode nextHead = null;
        int count = 0;
        while (true) {
            if (count == k) {
                ListNode reverse = reverse(left, cur);
                ListNode last = reverse;
                if (left == head) {
                    head = reverse;
                } else {
                    nextHead.next = reverse;
                }
                int num = 0;
                while (num < k - 1) {
                    last = last.next;
                    num++;
                }
                nextHead = last;
                left = cur;
                last.next = cur;
                count = 0;
            }
            if (cur == null) {
                break;
            }
            cur = cur.next;
            count++;
        }

        return head;
    }

    public static void main(String[] args) {
        int size = 60;
        long range = 10;

        String s = generateRandomLetterString(size);
        System.out.println(s);
//        ListNode head = generateRandomListNode(size, range);
//        System.out.println(printListNode(head));

//        ListNode listNode = reverseBetween(head, 1, 2);
//        System.out.println(printListNode(listNode));

//        ListNode listNode = reverseKGroup(head, 3);
//        System.out.println(printListNode(listNode));

//        ListNode right = head.next.next.next;
//
//        ListNode reverse = reverse(null, head, right);
//        System.out.println(printListNode(reverse));
//        ListNode last = reverse;
//        int count = 0;
//        while (count < 2) {
//            count++;
//            last = last.next;
//        }
//        last.next = right;
//
//        System.out.println(printListNode(reverse));
    }
}
