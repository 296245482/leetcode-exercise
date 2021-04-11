package com.jackie.easy;

/**
 * LeetCode-121
 *
 * @author Long Cheng
 * @date 2021/4/5.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
