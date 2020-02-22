package com.jackie.easy;

import com.jackie.datastructures.ListNode;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2020/2/22.
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);

        a.next = b;
        c.next = d;
        mergeTwoLists(a, c).print();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i = l1, j = l2;
        ListNode res = new ListNode();
        ListNode r = res;
        while (i != null && j != null) {
            if (i.val < j.val) {
                r.next = i;
                i = i.next;
            } else {
                r.next = j;
                j = j.next;
            }
            r = r.next;
        }
        if (i != null) {
            r.next = i;
        }
        if (j != null) {
            r.next = j;
        }
        return res.next;
    }
}

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
