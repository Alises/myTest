package com.example.demo.datastructure;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Create 2021/12/13 by Gq
 */
public class RedBlackTreeTest {

    public static void main(String[] args) throws JsonProcessingException {
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(8);
        rbTree.insert(3);
        rbTree.insert(5);
        rbTree.insert(1);
        rbTree.insert(23);
        rbTree.insert(13);
        rbTree.insert(22);
        System.out.println(rbTree.toString());
        rbTree.remove(23);
        System.out.println(rbTree);
    }
}
