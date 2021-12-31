package com.example.demo.leetcode.simple;

/**
 * 2019/12/9 create by Gq
 * 在一个有序数组里面 存在重复项
 * 输入一个数字 判断该数字出现的次数
 * 例如： [1,2,3,3,4,5,6]  输入 2 => 1 输入 3 => 2
 */

public class RepeatCountTest {
    private static int[] arrays = {1, 2, 3, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 8, 8};


    public static int searchTest(int num) {
        int low = 0;
        boolean searched = false;

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == num) {
                if (!searched) {
                    low = i;
                    searched = true;
                }
            } else {
                if (searched) {
                    return i - low;
                }
            }
        }

        if (searched) {
            return arrays.length - low;
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println(searchTest(8));
    }
}
