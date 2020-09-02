package com.jackie.easy;

import com.sun.deploy.util.StringUtils;

/**
 * LeetCode-
 *
 * @author 29624
 * @date 2020/9/2
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle) || haystack.equals(needle)) {
            return 0;
        }
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        for (int i = 0; i <= haystackChar.length-needle.length(); i++) {
            int index = i;
            for (int j = 0; j < needleChar.length; ) {
                if (haystackChar[index] == needleChar[j]) {
                    if (j == needle.length()-1) {
                        return i;
                    }
                    index++;
                    j++;
                } else {
                    break;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("aaaaa", "aab"));
        System.out.println(new StrStr().strStr("heello", "llo"));
        System.out.println(new StrStr().strStr("", "a"));
        System.out.println(new StrStr().strStr("aaa", "a"));
    }
}

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */