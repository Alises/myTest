package com.example.demo.leetcode.simple;

/**
 * 2019/11/15 create by Gq
 * 两数相除
 *
 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 返回被除数dividend除以除数divisor得到的商。

 示例1:
 输入: dividend = 10, divisor = 3
 输出: 3
 示例2:
 输入: dividend = 7, divisor = -3
 输出: -2
 说明:
 被除数和除数均为 32 位有符号整数。
 除数不为0。
 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回 2^31− 1。
 */

public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }

    private static int divide(int dividend, int divisor) {
        System.out.println(dividend >> divisor);
        return 0;
    }
}
