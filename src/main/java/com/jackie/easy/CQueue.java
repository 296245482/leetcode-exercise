package com.jackie.easy;

import java.util.Stack;

/**
 * LeetCode-
 *
 * @author Long Cheng
 * @date 2021/3/13.
 */
public class CQueue {

    Stack<Integer> first = new Stack<>();
    Stack<Integer> secord = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        first.push(value);
    }

    public int deleteHead() {
        if (!secord.empty()) {
            return secord.pop();
        }
        if (first.empty()) {
            return -1;
        }
        while (!first.empty()) {
            secord.push(first.pop());
        }
        return secord.pop();
    }
}
