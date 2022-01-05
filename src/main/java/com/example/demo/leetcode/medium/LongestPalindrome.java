package com.example.demo.leetcode.medium;

/**
 * Create 2022/1/4 by Gq
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {


        return null;
    }
    /**
     * 方法可行  但针对重复的长字符串效率低
     * @param args
     */
//    public static String longestPalindrome(String s) {
//        int n = s.length();
//        String result = s.charAt(0) + ""; //返回的字符串
//        for (int i = 0; i < n; i++) {
//            // 找到当前第一个字符
//            char c = s.charAt(i);
//            // 从后续字符串中找到有没有存在的
//            int nextIdx;
//            int fromIdx = i + 1;
//            // 如果存在
//            while ((nextIdx = s.indexOf(c, fromIdx)) > -1) {
//                fromIdx = nextIdx + 1;
//                // a --> nqkjnd <-- a
//                // 从 下一个字符开始到最后一个字符结束
//                // l 左指针  r 右指针
//                for (int l = i, r = nextIdx; l <= nextIdx; ) {
//                    // 如果指针重合或 左指针大于右指针 退出循环
//                    if(l >= r) {
//                        // 替换更长字符串
//                        if(nextIdx - i + 1 > result.length()) {
//                            result = s.substring(i, nextIdx + 1);
//                        }
//                        break;
//                    }
//                    // 如果两个字符不相等 则退出
//                    if(s.charAt(l++) != s.charAt(r--)) {
//                        break;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
