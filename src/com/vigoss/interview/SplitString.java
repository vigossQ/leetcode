package com.vigoss.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Reimu Hakurei
 * @date 2023/1/8 19:53
 */
public class SplitString {

    public static int solution(String S) {
        Set<Character> set = new HashSet<>();
        int count = 1;

        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                set.clear();
                count++;
            }
            set.add(S.charAt(i));
        }
        return count;
    }
}
