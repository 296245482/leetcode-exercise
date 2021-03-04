package com.jackie.easy;

/**
 * LeetCode-26
 *
 * @author 29624
 * @date 2020/8/31
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 0, j = 1, n = 0;
        nums[n++] = nums[i];
        while (j < nums.length) {
            while (j < nums.length) {
                if (nums[j] == nums[i]) {
                    j++;
                } else {

                    break;
                }
            }
            if (j < nums.length) {
                nums[n++] = nums[j];
            }
            i = j;
            j++;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        int n = new RemoveDuplicates().removeDuplicates(nums);
        for (int i = 0; i < n; i ++) {
            System.out.println(nums[i]);
        }
    }
}
/**
 * 去掉排序队列内的重复元素，要求只能使用o(1)的额外空间
 */