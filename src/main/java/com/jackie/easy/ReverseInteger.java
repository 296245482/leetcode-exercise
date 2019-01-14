package com.jackie.easy;

/**
 * leetcode-7
 *
 * @author chenglong
 * @date 2019/1/14.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0){
            int tail = x % 10;
            int newRes = result * 10 + tail;
            if((newRes - tail) / 10 != result){
                return 0;
            }
            result = newRes;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new ReverseInteger().reverse(-324351));
    }
}

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
 */
