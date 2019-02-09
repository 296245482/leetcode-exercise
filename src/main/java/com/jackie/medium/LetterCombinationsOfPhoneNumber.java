package com.jackie.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-17
 * 求解九宫格键盘由数字到字母的可能映射，采用回溯，空间复杂度过高...后续要修改
 * @author Long Cheng
 * @date 2019/2/9.
 */
public class LetterCombinationsOfPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return res;
        }

        char[] digitsChars = digits.toCharArray();
        combine(digitsChars, 0, new StringBuilder());
        return res;
    }

    private void combine(char[] digitsChars, int index, StringBuilder resTemp) {
        if (index == digitsChars.length) {
            res.add(resTemp.toString());
            return;
        }
        for (int i = 0; i < KEYS[digitsChars[index] - '0'].length(); i++) {
            StringBuilder temp = new StringBuilder(resTemp.substring(0,index));
            combine(digitsChars, index + 1, temp.append(KEYS[digitsChars[index] - '0'].toCharArray()[i]));
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
    }
}

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */