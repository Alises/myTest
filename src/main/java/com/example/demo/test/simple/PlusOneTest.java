package com.example.demo.test.simple;

/**
 * 2019/12/25 create by Gq
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了 整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class PlusOneTest {

    public static void main(String[] args) {
        int[] a = {9};
        show(plusOne(a));
    }


    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] ++;
            digits[i] = digits[i] % 10;

            if(digits[i] != 0) return digits;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    public static void show(int[] ints) {

        for(int i = 0; i < ints.length; i ++) {
            if(i > 0) System.out.print(",");
            System.out.print(ints[i]);
        }
    }

}
