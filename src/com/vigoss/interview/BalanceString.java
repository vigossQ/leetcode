package com.vigoss.interview;

import java.util.*;

/**
 * @author Reimu Hakurei
 */
public class BalanceString {

    public static int shortestBalancedString(String s) {
        char[] chars = s.toCharArray();
        Set<Character> fullSet = new HashSet<>();
        for (char c : chars) {
            fullSet.add(c);
        }
        Set<Character> outSet = new HashSet<>();
        for (Character c : fullSet) {
            if (!fullSet.contains((char) (c + 32)) && !fullSet.contains((char) (c - 32))) {
                outSet.add(c);
            }
        }
        System.out.println(fullSet);
        System.out.println(outSet);
        if (outSet.size() > 0) {
            chars = Arrays.copyOf(chars, chars.length + 1);
            chars[chars.length - 1] = (char) outSet.toArray()[0];
        }
        Set<Character> minSet = new HashSet<>();
        Stack<Character> minStack = new Stack<>();
        int min = chars.length;
        for (char c : chars) {
            if (outSet.contains(c)) {
                Map<Character, Character> curMap = new HashMap<>();
                int smin = minStack.size();
                while (!minStack.isEmpty()) {
                    Character pop = minStack.pop();
                    minSet.add(pop);
                    if (Character.isLowerCase(pop)) {
                        curMap.put(pop, (char) (pop - 32));
                    }
                    if (Character.isUpperCase(pop)) {
                        curMap.put(pop, (char) (pop + 32));
                    }
                }
                for (Character value : curMap.values()) {
                    if (!minSet.contains(value)) {
                        minSet.clear();
                    }
                }
                if (minSet.size() > 0) {
                    min = minSet.size() % 2 == 0 ? Math.min(smin, min) : min;
                    minSet.clear();
                }
            } else {
                if (!minStack.isEmpty()) {
                    Character peek = minStack.peek();
                    if (Character.isLowerCase(c)) {
                        if (c - 32 == (int) peek) {
                            return 2;
                        }
                    }
                    if (Character.isUpperCase(c)) {
                        if (c + 32 == (int) peek) {
                            return 2;
                        }
                    }
                }

                minStack.push(c);
            }
        }

        if (outSet.size() > 0 && min == chars.length) {
            min = -1;
        }

        return min;
    }

    /**
     * 滑动窗口解法
     *
     * @param s
     * @return
     */
    public static int shortestBalancedString2(String s) {
        char[] chars = s.toCharArray();
        String minResult = "";
        for (int left = 0; left < chars.length - 1; left++) {
            Map<Character, Character> charMap = new HashMap<>();
            Set<Character> charSet = new HashSet<>();
            for (int right = left; right < chars.length; right++) {
                char cur = chars[right];
                Character c = charMap.get(cur);
                if (c == null && !charSet.contains(cur)) {
                    if (Character.isLowerCase(cur)) {
                        charMap.put((char) (cur - 32), cur);
                    }
                    if (Character.isUpperCase(cur)) {
                        charMap.put((char) (cur + 32), cur);
                    }
                } else {
                    charMap.remove(cur);
                }
                if (charMap.size() == 0) {
                    String result = s.substring(left, right + 1);
                    if ("".equals(minResult)) {
                        minResult = result;
                    } else if (charSet.size() >= minResult.length() - 1) {
                        break;
                    } else {
                        minResult = Math.min(minResult.length(), result.length()) == result.length() ? result : minResult;
                        System.out.println(minResult);
                    }
                    break;
                }
                charSet.add(cur);
            }
        }
        return minResult.length() == 0 ? -1 : minResult.length();
    }

    public static void main(String[] args) {
//        String s = CodeUtil.generateRandomLetterString(7);

//        "sHhsDDhsddH"
        String s = "sDHDhd";
        System.out.println(s);
        int i = shortestBalancedString2(s);
        System.out.println(i);
    }
}
