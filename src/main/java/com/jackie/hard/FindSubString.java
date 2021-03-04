package com.jackie.hard;

import com.jackie.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode-
 *
 * @author 29624
 * @date 2020/9/5
 */
public class FindSubString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null | "".equals(s) || words.length == 0) {
            return res;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }

        int wordLen = words[0].length();
        int subStringLen = wordLen * words.length;
        for (int i = 0; i < s.length() - subStringLen + 1; i ++) {
            Map<String, Integer> tempWordsMap = new HashMap<>(wordsMap);
            for (int j = 0; j < subStringLen; j += wordLen) {
                String tempWord = s.substring(i+j, i+j+wordLen);
                if (tempWordsMap.containsKey(tempWord)) {
                    tempWordsMap.put(tempWord, tempWordsMap.get(tempWord) - 1);
                    if (tempWordsMap.get(tempWord) == 0) {
                        tempWordsMap.remove(tempWord);
                    }
                } else {
                    break;
                }
            }

            if (tempWordsMap.size() == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"bar","foo"};
        List<Integer> res = new FindSubString().findSubstring("barfoothefoobareae", words);
        Utils.sout(res);

    }
}


/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 */