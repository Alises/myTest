package com.example.demo.leetcode.medium;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Create 2021/12/31 by Gq
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 *
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = null, last = null;
//        // 进位
//        int present = 0;
//        while (l1 != null || l2 != null) {
//            int a = l1 == null ? 0 : l1.val;
//            int b = l2 == null ? 0 : l2.val;
//            int count = a + b + present;
//            present = count / 10;
//
//            // 为空说明是第一个值
//            ListNode next = new ListNode(count % 10);
//            if(result == null) {
//                last = result = next;
//            } else {
//                last.next = next;
//                last = next;
//            }
//
//            if(l1 != null) {
//                l1 = l1.next;
//            }
//
//            if(l2 != null) {
//                l2 = l2.next;
//            }
//        }
//
//        if(present > 0) {
//            last.next = new ListNode(present);
//        }
//
//        return result;
//    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;

        int present = (a + b) / 10;
        if (l1 != null) {
            l1 = l1.next;
        }

        if(l2 != null) {
            l2 = l2.next;
        }

        if(present > 0) {
            if(l1 != null) {
                l1.val += present;
            } else if(l2 != null) {
                l2.val += present;
            } else {
                l1 = new ListNode(present);
            }
        }

        return new ListNode((a + b) % 10, addTwoNumbers(l1, l2));
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
//        double a = 1000000000000000000000000000001d;
//        System.out.println(a);
    }
}
