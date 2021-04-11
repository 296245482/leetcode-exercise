package com.jackie.easy;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/3/13.
 */
public class Fib {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i ++) {
            result[i] = (result[i-1] + result[i-2]) % 1000000007;
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib(45));
    }
}
