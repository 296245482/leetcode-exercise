package com.jackie.medium;

/**
 * leetcode-5
 * 获取字符串最长回文,从一个中间点出发,向两边扩展,如果两边相等就继续扩展,中间点一共2n-1个
 *
 * @author Long Cheng
 * @date 2019/1/8.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */