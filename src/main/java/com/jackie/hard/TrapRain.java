package com.jackie.hard;

/**
 * LeetCode接雨
 *
 * @author Long Cheng
 * @date 2021/3/5.
 */
public class TrapRain {

    public int trap(int[] height) {
        int len = height.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int leftMax = 0, rightMax = 0;
            if (i > 0) {
                leftMax = findMax(height, 0, i - 1);
            } else {
                leftMax = height[0];
            }

            if (i < len - 1) {
                rightMax = findMax(height, i + 1, len - 1);
            } else {
                rightMax = height[len - 1];
            }
            res += (Math.min(leftMax, rightMax) - height[i] > 0) ? (Math.min(leftMax, rightMax) - height[i]) : 0;
        }
        return res;
    }

    private int findMax(int[] height, int begin, int end) {
        if (begin == end) {
            return height[begin];
        }
        int max = Integer.MIN_VALUE;
        for (int i = begin; i <= end; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 0, 3, 2, 5};
        System.out.println(new TrapRain().trap(array));
    }
}
