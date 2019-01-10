package com.jackie.medium;

/**
 * LeetCode-6
 * 横向遍历,第一行和最后一行元素差为2*numRows-2,然后通过行数的变化处理中间的"之"字部分即可
 * @author chenglong
 * @date 2019/1/10.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1) {
            return s;
        }
        int step = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i += step) {
            result.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = i; j < len; j += step) {
                result.append(s.charAt(j));
                if (j + step - 2 * i < len) {
                    result.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        for (int i = numRows - 1; i < len; i += step) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
