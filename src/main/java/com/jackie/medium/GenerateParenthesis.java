package com.jackie.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        System.out.println(res);

        return res;
    }

    private void dfs(String item, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(item);
            return;
        }
        if (left > right) {
            return;
        }
        if (right > 0) {
            dfs(item + ")", left, right-1, res);
        }
        if (left > 0) {
            dfs(item + "(", left - 1, right, res);
        }
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
