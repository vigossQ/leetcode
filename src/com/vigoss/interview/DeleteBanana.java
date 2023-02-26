package com.vigoss.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Reimu Hakurei
 * @date 2023/1/8 19:34
 */
public class DeleteBanana {

    public static int solution(String S) {
        // Implement your solution here
        List<Character> aList = new ArrayList<>();
        List<Character> bList = new ArrayList<>();
        List<Character> nList = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            if ('A' == S.charAt(i)) {
                aList.add(S.charAt(i));
            }
            if ('B' == S.charAt(i)) {
                bList.add(S.charAt(i));
            }
            if ('N' == S.charAt(i)) {
                nList.add(S.charAt(i));
            }
        }

        if (aList.size() < 3 || bList.size() < 1 || nList.size() < 2) {
            return 0;
        }

        int aCount = aList.size() / 3;
        int bCount = bList.size();
        int nCount = nList.size() / 2;
        return Math.min(Math.min(aCount, bCount), nCount);
    }

    public static void main(String[] args) {
        String s = "BANANA";
        int solution = solution(s);
        System.out.println(solution);
    }
}
