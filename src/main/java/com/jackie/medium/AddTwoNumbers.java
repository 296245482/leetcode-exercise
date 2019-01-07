package com.jackie.medium;

import com.jackie.datastructures.ListNode;

/**
 * LeetCode-2
 * 链表数字相加
 * @author Long Cheng
 * @date 2019/1/5.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = resHead;
        int carry = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            sum = sum % 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(p.next != null){
                p = p.next;
            }
            if(q.next != null){
                q = q.next;
            }
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return resHead.next;
    }
}

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */