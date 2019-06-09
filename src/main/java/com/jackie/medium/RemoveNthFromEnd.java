package com.jackie.medium;

import com.jackie.datastructures.ListNode;

/**
 * LeetCode-19
 * 移除链表末尾第N元素，两个指针，一个快一个慢遍历链表，记录走的慢的节点以及他们的前继，移除
 *
 * @author Long Cheng
 * @date 2019/5/30.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        for (int i = 1; i < n; i++) {
            first = first.next;
        }
        ListNode nowNode = head;
        ListNode preNode = new ListNode();
        if (first.next == null) {
            head = head.next;
        }
        while (first.next != null) {
            preNode = nowNode;
            nowNode = nowNode.next;
            first = first.next;
        }
        preNode.next = nowNode.next;
        return head;
    }

    /**
     * main test
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = ListNode.getListByArray(new int[]{5, 4, 3, 2, 1});
        node = new RemoveNthFromEnd().removeNthFromEnd(node, 5);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}

/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

 */