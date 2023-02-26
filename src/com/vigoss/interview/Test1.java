package com.vigoss.interview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Reimu Hakurei
 * @date 2023/1/9 18:26
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>(n);
        int result = -1, x;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            if (map.get(x) != null) {
                result = Math.max(i - map.get(x), result);
                continue;
            }
            map.put(x, i);
        }
        System.out.println(result);
        sc.close();
    }
}
