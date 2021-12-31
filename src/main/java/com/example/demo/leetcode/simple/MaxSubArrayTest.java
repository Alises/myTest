package com.example.demo.leetcode.simple;

/**
 * 2020/1/28 create by Gq
 */

/*
给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释:连续子数组[4,-1,2,1] 的和最大，为6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

public class MaxSubArrayTest {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int start = 0;
        int end = start + 1;

        for (; end < nums.length; ) {
            if (nums[start] < nums[end]) {

            }
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int b = maxSubArray(array);

        System.out.println(b);
    }

}
