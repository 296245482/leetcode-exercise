package com.jackie.medium;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/4/4.
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return findPosition(nums, 0, nums.length - 1, k);
    }

    private int findPosition(int[] nums, int start, int end, int k) {
        if (start > end || end > nums.length || start > nums.length) {
            return 0;
        }
        int low = start;
        int high = end;
        int curr = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= curr) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= curr) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[end] = curr;
        if (end == nums.length-k) {
                return nums[end];
        } else if (end > nums.length-k) {
            return findPosition(nums, low, end - 1, k);
        } else {
            return findPosition(nums, end + 1, high, k);
        }
    }

    public static void main(String[] args) {
        int[] aa = {4,3,1,5,2};
        System.out.println(new FindKthLargest().findKthLargest(aa, 3));
    }
}
