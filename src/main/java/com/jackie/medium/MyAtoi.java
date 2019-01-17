package com.jackie.medium;

/**
 * LeetCode-8
 * char数组挨个处理,对于大于int最大值的情况从前一位开始判断
 * @author chenglong
 * @date 2019/1/17.
 */
public class MyAtoi {
    static int INT_MAX = Integer.MAX_VALUE;
    static int INT_MIN = Integer.MIN_VALUE;

    public int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int i = 0, base = 0, sign = 1;
        while (chars[i] == ' ') {
            i++;
            if(i >= chars.length){
                return 0;
            }
        }
        if (chars[i] == '-') {
            i++;
            sign = -1;
        } else if (chars[i] == '+') {
            i++;
            sign = 1;
        }
        while(i < chars.length && isdigit(chars[i])){
            if(base > INT_MAX / 10 || (base == INT_MAX / 10 && (chars[i] > '7'))){
                return sign == -1 ? INT_MIN : INT_MAX;
            }
            base = base * 10 + chars[i] - '0';
            i ++;
        }
        return sign * base;
    }
    private boolean isdigit(char item){
        return (item >= '0' && item <= '9');
    }
    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi(""));
    }
}

/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 */