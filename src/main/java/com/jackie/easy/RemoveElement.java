package com.jackie.easy;

/**
 * LeetCode-27
 *
 * @author 29624
 * @date 2020/9/2
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] == val)) {
            return 0;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] a = {0,0,0,0};
        System.out.println(new RemoveElement().removeElement(a, 0));
        for(int i = 0; i < a.length; i ++) {
            System.out.println(a[i]);
        }
    }
}

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */