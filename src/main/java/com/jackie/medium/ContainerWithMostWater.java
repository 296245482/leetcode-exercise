package com.jackie.medium;

/**
 * LeetCode-11
 * 水桶短板问题，两个指针，分别指着结束处和开始处，依次计算面积，然后高度稍低的那一个指针向中间移动
 * @author Long Cheng
 * @date 2019/2/5.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int start = 0, end = height.length - 1;
        int h = 0, res = 0;
        while (start < end && end < height.length) {
            h = height[start] > height[end] ? height[end] : height[start];
            int temp = h * (end - start);
            if (temp > res) {
                res = temp;
            }
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */