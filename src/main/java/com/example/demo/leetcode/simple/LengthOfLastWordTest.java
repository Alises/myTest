package com.example.demo.leetcode.simple;

/**
 * 2019/12/25 create by Gq
 *
 给定一个仅包含大小写字母和空格' '的字符串，返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0。

 说明：一个单词是指由字母组成，但不包含任何空格的字符串。

 示例:

 输入: "Hello World"
 输出: 5

 */

public class LengthOfLastWordTest {


    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;

        for(int i = s.length() - 1; i >= 0; i --) {
            char c = s.charAt(i);

            if(c == ' ' && length == 0) continue;
            if(c == ' ' && length > 0) break;

            length ++;
        }
        return length;
    }
}
