package com.example.demo.leetcode.simple;

/**
 * 2019/10/24 create by gaoqian
 * 一个数的二进制有多少个1
 */

public class BinaryTest {

    public static void main(String[] args) {
        function1(300);
    }

    /**
     * 一个数字的二进制有多少个1
     * @param i
     */
    private static int function (int i) {
        int count = 0;
        int temp = i;
        while(i > 0) {
            i = i & (i - 1);
            count ++;
        }

        System.out.println(temp + "有 " + count + " 个1");

        return count;
    }

    /**
     * 0 ~ n 中的数字二进制共有多少个 1
     */
    private static void function1 (int n) {
        int count = 0;
        for(int i = 1; i < n; i ++) {
            count += function(i);
        }

        System.out.println("共有" + count + "个1");
    }
}
