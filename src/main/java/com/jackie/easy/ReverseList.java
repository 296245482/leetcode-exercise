package com.jackie.easy;

import com.jackie.datastructures.ListNode;
import com.jackie.hard.ReverseKGroupV2;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/4/4.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.print();
        new ReverseList().reverseList(a).print();
    }
}
