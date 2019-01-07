package com.jackie.datastructures;

import lombok.Data;

/**
 * ListNode
 * Link List Node
 * @author Long Cheng
 * @date 2019/1/5.
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

}
