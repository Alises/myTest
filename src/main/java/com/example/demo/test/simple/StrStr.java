package com.example.demo.test.simple;

/**
 * 2019/11/15 create by Gq
 * <p>
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "3ll";
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;

        char[] hays = haystack.toCharArray();
        char[] needs = needle.toCharArray();
        int i = 0;
        int j = 0;
        while (true) {
            if (i + j >= hays.length) return -1;
            if (needs[j] == hays[i + j]) {
                j++;
            } else {
                i++;
                j = 0;
            }
            if (j == needs.length) return i;
        }
    }
}
