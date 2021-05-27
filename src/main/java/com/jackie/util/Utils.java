package com.jackie.util;

import com.google.common.base.Joiner;

import java.util.List;

/**
 * LeetCode-
 *
 * @author 29624
 * @date 2020/9/5
 */
public class Utils {
    public static void sout(List list) {
        String res = Joiner.on(',').join(list);
        System.out.println(res);
    }
}
// develop2