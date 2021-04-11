package com.jackie.hard;

import com.jackie.datastructures.ListNode;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/4/4.
 */
public class ReverseKGroupV2 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode start = preHead;
        ListNode end = preHead;

        while (end.next != null) {
            for (int i = 0; i < k & end != null; i ++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode begin = start.next;
            ListNode next = end.next;
            end.next = null;
            start.next = reverse(begin);
            begin.next = next;
            start = begin;
            end = start;
        }
        return preHead.next;
    }

    private ListNode reverse(ListNode head) {
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
        new ReverseKGroupV2().reverseKGroup(a, 3).print();
    }
}
