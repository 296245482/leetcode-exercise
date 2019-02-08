package com.jackie.easy;

/**
 * LeetCode-14
 *
 * @author Long Cheng
 * @date 2019/2/7.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1 || strs[0].length() < 1){
            return "";
        }
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (true) {
            if(strs[0].toCharArray().length <= index){
                return res.toString();
            }
            char temp = strs[0].toCharArray()[index];
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].toCharArray().length <= index || strs[i].toCharArray()[index] != temp) {
                    return res.toString();
                }
            }
            res.append(temp);
            index++;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */