package com.jackie.easy;

import java.util.Stack;

/**
 * LeetCode-20
 *
 * @author Long Cheng
 * @date 2019/6/12.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char charItem : s.toCharArray()) {
            if(charItem == '('){
                stack.push(')');
            }else if(charItem == '['){
                stack.push(']');
            }else if(charItem == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != charItem){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.print(new ValidParentheses().isValid("(("));
    }
}

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.


 */