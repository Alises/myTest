package com.example.demo.test;

/**
 * 2019/8/1 create by gaoqian
 * 排序算法
 */


public class SortTest {

    private static int[] array = {12, 234, 456, 36, 235, 123, 345, 124, 462, 97};


    public static void main(String[] args) {
        bubbleSort();
//        selectSort();
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort() {
        //相邻两个比较  升序
        for (int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j ++ ) {
                //升序  如果第一个比第二个大 则交换
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        outPut();
    }

    /**
     * 选择排序
     */
    private static void selectSort () {

        for(int i = 0; i < array.length ; i ++ ) {
            int currentIndex = i;
            for(int j = i + 1; j < array.length; j ++) {
                if(array[currentIndex] > array[j]) {
                    currentIndex = j;
                }
            }
            if(currentIndex != i) {
                int temp = array[currentIndex];
                array[currentIndex] = array[i];
                array[i] = temp;
            }
        }

        outPut();
    }

    /**
     * 打印数据
     */
    private static void outPut() {
        int total = 0;
        for(int i : array) {
            if(total > 0)
                System.out.print(",");
            System.out.print(i);
            total ++;
        }
    }
}
