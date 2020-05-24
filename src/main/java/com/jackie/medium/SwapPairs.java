package com.jackie.medium;

import com.jackie.datastructures.ListNode;

/**
 * 两两交换链表中的元素，递归做法，每次直接交换这个点和下一个点
 *
 * @author chenglong
 * @date 2020/5/24.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *  
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
