package com.jackie.datastructures;

import lombok.Data;

/**
 * ListNode
 * Link List Node
 *
 * @author Long Cheng
 * @date 2019/1/5.
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        val = 0;
        next = null;
    }

    public ListNode(int x) {
        val = x;
    }

    /**
     * int[]型数组返回链表
     *
     * @param nums
     * @return
     */
    public static ListNode getListByArray(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        ListNode first = new ListNode(nums[0]);
        if (nums.length == 1) {
            return first;
        }
        ListNode node = first;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            node.next = temp;
            node = temp;
        }
        return first;
    }

}
