package com.jackie.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符串的排列：dfs深度搜索，每次固定一位，交换剩下的几位达到目的
 *
 * @author Long Cheng
 * @date 2021/3/16.
 */
public class Permutatio {
    List<String> res = new ArrayList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
        }
        Set<Character> contained = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (contained.contains(c[i])) {
                continue;
            }
            contained.add(c[i]);
            swap(i, x);
            dfs(x+1);
            swap(i, x);
        }
    }

    private void swap(int x, int y) {
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }


    public static void main(String[] args) {
        new Permutatio().permutation("abc");
    }
}
