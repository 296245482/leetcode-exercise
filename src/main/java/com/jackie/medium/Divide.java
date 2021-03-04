package com.jackie.medium;

import com.sun.org.apache.xpath.internal.operations.Div;

/**
 * LeetCode-
 *
 * @author 29624
 * @date 2020/9/3
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = -1;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        if (a > b) {
            return 0;
        }
        int res = div(a, b);
        return flag == 1 ? res : -res;
    }

    private int div(int a, int b) {
        if (a > b) {
            return 0;
        }
        int res = 1;
        int vb = b;
        while ((vb + vb) >= a && (vb + vb) < 0) {
            res = res + res;
            vb = vb + vb;
        }
        return res + div(a - vb, b);
    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648, -1));
    }
}

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */