package com.example.demo.test.simple;

/**
 * 2019/12/6 create by Gq
 * 二分查找
 */

public class BinarySearchTest {

    private static int[] int_array = {1, 2,2, 3, 4, 5,5, 6, 7, 8,8, 9, 10};


    public static int binarySearch(int[] array, int fromIndex, int toIndex, int search) {
        int low = fromIndex;
        int heigh = toIndex - 1;
        int i = 0;
        while (low <= heigh) {
            System.out.println("======" +  ++ i);
            int mid = (low + heigh) >>> 1;

            if(array[mid] > search) {
                heigh = mid - 1;
            } else if(array[mid] < search){
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -(low + 1);
    }


    public static void main(String[] args) {
        System.out.println(binarySearch(int_array,0, int_array.length - 1, 8));
    }



}
