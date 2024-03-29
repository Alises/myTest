package com.example.demo.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019/11/13 create by Gq
 *
 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 */

public class TwoNumberSum {

    public static void main(String[] args) {
        int target = 8;
        int[] nums = {0,4,1,4,2,1,9,2,5,8,3,4};
        int[] indexs = twoSum(nums,target);
        for(int i : indexs) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++){
            Integer temp = map.get(target - nums[i]);
            if(temp != null) {
                return new int[]{temp - 1, i};
            }
            map.put(nums[i], i + 1);
        }
        return null;
    }
}
