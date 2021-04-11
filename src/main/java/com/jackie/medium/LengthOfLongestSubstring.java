package com.jackie.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode-3
 * 最长连续不重复子串，字符前后两个指针，维护一个滑动窗口
 *
 * @author Long Cheng
 * @date 2019/1/5.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (position.containsKey(s.charAt(j))) {
                i = Math.max(i, position.get(s.charAt(j)) + 1);
            }
            position.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstringV2(String s) {
        Set<Character> occured = new HashSet<>();
        int res = 0;
        int right = 0;
        for (int left = 0; left < s.length(); left++) {
            if (left != 0) {
                occured.remove(s.charAt(left - 1));
            }
            while (right < s.length() && !occured.contains(s.charAt(right))) {
                occured.add(s.charAt(right));
                right++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstringV2("abcacbl"));
    }
}

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */