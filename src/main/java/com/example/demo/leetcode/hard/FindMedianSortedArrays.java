package com.example.demo.leetcode.hard;

/**
 * Create 2022/1/4 by Gq
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] s = new int[length];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                s[idx ++] = nums1[i];
                i ++;
            } else {
                s[idx ++] = nums2[j];
                j ++;
            }
        }
        if(i < nums1.length) {
            while (i < nums1.length) {
                s[idx ++] = nums1[i ++];
            }
        }
        if(j < nums2.length) {
            while (j < nums2.length) {
                s[idx ++] = nums2[j++];
            }
        }
        double mindle;
        if(length % 2 == 0) {
            mindle = (s[length / 2 - 1] + s[length / 2]) / 2.0;
        } else {
            mindle = s[length / 2];
        }
        return mindle;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
