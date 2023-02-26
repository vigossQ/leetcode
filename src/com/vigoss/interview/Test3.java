package com.vigoss.interview;

import java.util.Stack;

/**
 * @author Reimu Hakurei
 * @date 2023/1/9 19:51
 */
public class Test3 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String s = "{A3B1{C}3}3";
        Stack<Character> stack = new Stack<>();
        String result = process(0, s, stack);
        System.out.println(result);
    }

    private static String process(int i, String s, Stack<Character> stack) {
        StringBuilder res = new StringBuilder();
        if (Character.isLetter(s.charAt(i))) {
            stack.push(s.charAt(i));
            return process(++i, s, stack);
        } else if (Character.isDigit(s.charAt(i))) {
            Stack<Character> stc = new Stack<>();
            while (!stack.isEmpty()) {
                Character pop = stack.pop();
                if (Character.isLetter(pop)) {
                    stc.push(pop);
                }
            }
            StringBuilder tmp = new StringBuilder();
            while (!stc.isEmpty()) {
                tmp.append(stc.pop());
            }
            for (int j = 0; j < Integer.parseInt(String.valueOf(s.charAt(i))); j++) {
                res.append(tmp);
            }
            return res.toString();
        } else if ('{' == s.charAt(i)) {
            Stack<Character> stc = new Stack<>();
            String process = process(++i, s, stc);
            for (int j = 0; j < process.length(); j++) {
                stack.push(process.charAt(j));
            }
            ++i;
            return process(++i, s, stack);
        } else if ('}' == s.charAt(i)) {
            stack.push(s.charAt(i));
            return process(++i, s, stack);
        } else {
            return res.toString();
        }
    }
}
