package com.example.demo.demotest;

import java.util.ArrayList;

/**
 * Create 2021/12/9 by Gq
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrs = new ArrayList<>();
        arrs.add(1);
        arrs.add(3);
        arrs.add(13);
        arrs.add(14);
        arrs.add(16);

        arrs.remove(Integer.valueOf(14));

    }
}
