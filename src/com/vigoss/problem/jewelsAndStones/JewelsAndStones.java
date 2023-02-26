package com.vigoss.problem.jewelsAndStones;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vigoss
 * <p>
 * _771_宝石与石头
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * @date 2020/10/2
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "";
        String S = "";
        int i = new JewelsAndStones().numJewelsInStones(J, S);
        System.out.println(i);
    }

    public int numJewelsInStones(String J, String S) {
        char[] charsJ = J.toCharArray();
        char[] charsS = S.toCharArray();
        int count = 0;
        Set<Character> setJ = new HashSet<>();
        for (char c : charsJ) {
            setJ.add(c);
        }

        for (char s : charsS) {
            if (setJ.contains(s)) {
                count++;
            }
        }
        return count;
    }
}
