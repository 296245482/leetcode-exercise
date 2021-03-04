package com.jackie.hard;

import com.jackie.datastructures.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 每k个一组翻转，思路，k个分为一组，单个翻转，然后拼接
 *
 * @author chenglong
 * @date 2020/5/24.
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode begin = head;
        ListNode end = null;
        pre.next = head;
        after.next = head;
        List<ListNode> resList = new ArrayList<>();
        while(begin != null) {
            ListNode firstTemp = begin;
            for (int i = 0; i < k; i ++) {
                if (firstTemp == null) {
                    return resList.get(0);
                }
                firstTemp = firstTemp.next;
            }
            for (int i = 0; i < k; i++) {
                after = after.next;
            }
            end = after.next;
            after.next = null;
            begin  = reverseList(begin, k);
            resList.add(begin);
            pre.next = begin;
            for (int i = 0; i < k; i++) {
                pre = pre.next;
            }
            after = pre;
            after.next = end;
            begin = after.next;
        }
        return resList.get(0);
    }

    private ListNode reverseList(ListNode listNode, int k) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode firstTemp = listNode;
        for (int i = 0; i < k; i ++) {
            if (firstTemp == null) {
                return listNode;
            }
            firstTemp = firstTemp.next;
        }
        ListNode l1 = null;
        ListNode l2 = listNode;
        ListNode l3 = l2.next;
        while (l3 != null) {
            ListNode newNode = l3.next;
            l3.next = l2;
            l2.next = l1;
            l1 = l2;
            l2 = l3;
            l3 = newNode;
        }
        return l2;
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
        new ReverseKGroup().reverseKGroup(a, 2).print();
    }
}

/**
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5
 */
