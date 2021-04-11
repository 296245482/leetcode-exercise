package com.jackie.easy;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/4/5.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], pre = 0;
        for (int item : nums) {
            pre = Math.max(item, pre + item);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}
