package com.jackie.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode-1
 *
 * @author Long Cheng
 * @date 2019/1/5.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i ++){
            int component = target - nums[i];
            if(temp.contains(component)){
                return new int[]{temp.indexOf(component), i};
            }
            temp.add(nums[i]);
        }
        return new int[]{};
    }
}
/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/