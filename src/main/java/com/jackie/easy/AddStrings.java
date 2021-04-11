package com.jackie.easy;

/**
 * LeetCode-415
 *
 * @author Long Cheng
 * @date 2021/4/5.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int num1Item = i >= 0 ? num1.charAt(i) - '0' : 0;
            int num2Item = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = num1Item + num2Item + carry;
            carry = sum / 10;
            res.append(sum % 10);
            i --;
            j --;
        }
        if (carry == 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
