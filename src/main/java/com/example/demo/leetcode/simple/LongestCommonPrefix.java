package com.example.demo.leetcode.simple;

/**
 * 2019/11/14 create by Gq
 * 最长公共前缀
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串""。

 示例1:
 输入: ["flower","flow","flight"]
 输出: "fl"
 示例2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母a-z。
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];

        for(int i = 1; i < strs.length; i ++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }

            if(prefix.length() == 0) return "";
        }
        return prefix;
    }
}
