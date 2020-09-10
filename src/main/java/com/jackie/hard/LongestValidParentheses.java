package com.jackie.hard;

import java.util.Stack;

/**
 * LeetCode-
 *
 * @author 29624
 * @date 2020/9/10
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        char[] chars = s.toCharArray();
        Stack<Integer> cal = new Stack<>();
        cal.push(-1);
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) {
                cal.push(i);
            } else{
                cal.pop();
                if (cal.empty()) {
                    cal.push(i);
                } else {
                    max = Math.max(max, i - cal.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}

/**
 * 给定一个只包含 '('和 ')'的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */