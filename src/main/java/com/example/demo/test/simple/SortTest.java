package com.example.demo.test.simple;

/**
 * 2019/8/1 create by gaoqian
 * 排序算法
 */


public class SortTest {

    private static int[] array = {12, 234, 456, 36, 235, 123, 345, 124, 462, 97};


    public static void main(String[] args) {
//        bubbleSort();
//        selectSort();
        quickSort(array, 0, array.length - 1);
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
     * 快速排序
     * @param l 左指针
     * @param r 右指针
     */
    private static void quickSort(int[] S, int l, int r) {
        if(l < r) {
            int i = l, j = r, temp = S[l];

            while (i < j) {
                while(i < j && S[j] >= temp)
                    j --;
                if(i < j) {
                    S[i++] = S[j];
                }

                while (i < j && S[i] <= temp)
                    i ++;
                if(i < j) {
                    S[j--] = S[i];
                }
            }
            S[i] = temp;
            outPut();
            quickSort(S, l, i -1);
            quickSort(S, i + 1, r);
        }
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
        System.out.println();
    }
}
