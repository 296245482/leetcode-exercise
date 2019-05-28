package com.jackie.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode-18
 * 四数求和问题，从一个元素开始逐步确定元素，适当的时候结束循环和跳过循环
 * @author Long Cheng
 * @date 2019/5/28.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 先做排序
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 4) {
            return ans;
        }
        for (int i = 0; i < len - 3; i++) {
            // 和前面较小的结合后超过目标直接结束循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 和后面较大的结合仍然小于目标值，开始找i后面较大的值
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            // 过滤相同元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 确定第二个元素
            for (int j = i + 1; j < len - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1, high = len - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        // 过滤相同元素
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}


/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums,
such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */