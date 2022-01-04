package com.example.demo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create 2021/12/31 by Gq
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
//        if(s == null || "".equals(s)) return 0;
//        int max = 0;
//        Set<Character> list = new HashSet<>();
//        for (int i = 0; i < s.length(); i ++) {
//            int j = 0;
//            while (i + j < s.length()) {
//                char s1 = s.charAt(i + j);
//                if(list.contains(s1)) {
//                    // 清空list
//                    list.clear();
//                    break;
//                }
//                list.add(s1);
//                j ++;
//            }
//            max = Math.max(max, j);
//        }
//        return max;
        int maxSize=0;
        int l =0 ;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int firstIndex = s.indexOf(c,l);
            if(firstIndex < i) {
                l = firstIndex+1;
            }
            maxSize = Math.max(i-l+1, maxSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
    }
}
