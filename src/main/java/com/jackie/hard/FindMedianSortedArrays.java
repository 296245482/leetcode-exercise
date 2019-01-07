package com.jackie.hard;

/**
 * LeetCode-4
 *
 * @author Long Cheng
 * @date 2019/1/5.
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2)
                    +
                    findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1)) / 2;
        } else {
            return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, total / 2 + 1);
        }
    }

    private double findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int total) {
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;
        if (m > n) {
            return findKth(nums2, start2, end2, nums1, start1, end1, total);
        }
        if (m == 0) {
            return nums2[total - 1];
        }
        if (total == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int p1 = Math.min(m, total / 2);
        int p2 = total - p1;
        if (nums1[p1 + start1 - 1] < nums2[p2 + start2 - 1]) {
            return findKth(nums1, start1 + p1, end1, nums2, start2, end2, total - p1);
        } else if (nums1[p1 + start1 - 1] > nums2[p2 + start2 - 1]) {
            return findKth(nums1, start1, end1, nums2, start2 + p2, end2, total - p2);
        } else {
            return nums1[start1 + p1 - 1];
        }
    }
}

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */