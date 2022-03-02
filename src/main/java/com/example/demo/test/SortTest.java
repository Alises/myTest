package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2019/8/1 create by gaoqian
 * 排序算法
 */


public class SortTest {

    private static int[] arrays = {456, 12, 234, 36, 235, 123, 345, 124, 462, 97};


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        bubbleSort(arrays);
//        selectSort(arrays);
//        quickSort(arrays, 0, array.length - 1);
//        insertSort(arrays);
//        shellSort(arrays);
        heapSort(arrays);
//        mergeSort(arrays, 0, arrays.length - 1);
//        countSort(arrays);
//        bucketSort(arrays);
//        radixSort(arrays);

        System.out.println("用时：" + (System.currentTimeMillis() - startTime));
        // 输出集合
        outPut();
    }

    /**
     * 冒泡排序
     * 冒泡排序是一个稳定排序
     * 时间负责度是 O(n^2)
     */
    private static void bubbleSort(int[] array) {
        //相邻两个比较  升序
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - 1 - i ; j ++ ) {
                //升序  如果第一个比第二个大 则交换
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     * 选择排序是一个不稳定排序
     * 时间复杂度是 O(n^2)
     */
    private static void selectSort (int[] array) {

        for(int i = 0; i < array.length ; i ++ ) {
            int currentIndex = i;
            for(int j = i + 1; j < array.length; j ++) {
                if(array[currentIndex] > array[j]) {
                    currentIndex = j;
                }
            }
            if(currentIndex != i) {
                swap(array, currentIndex, i);
            }
        }
    }

    /**
     * 快速排序
     * 快速排序是一个不稳定排序
     * 时间复杂度是O(nlogn)
     * @param l 左指针
     * @param r 右指针
     */
    private static void quickSort(int[] array, int l, int r) {
        if(l < r) {
            // temp 比较的基数
            int i = l, j = r, temp = array[l];

            while (i < j) {
                // 从后向前遍历：假如后面指针的数大于基数，只要两个指针不重合，则指针向前移动
                while(i < j && array[j] > temp)
                    j --;
                // 如果两个指针没有重合，说明找到了比基数小的值
                if(i < j) {
                    // 将后面的值放到前指针的位置并且将前指针向后移动
                    array[i++] = array[j];
                }
                // 从前向后遍历：假如前指针的数小于基数，只要指针不重合，则指针向后移动
                while (i < j && array[i] < temp)
                    i ++;
                // 如果两个指针不重合，说明找到了比基数大的值，需要把找到的值放到后面
                if(i < j) {
                    // 将前面的值放到后指针的位置，并将后指针向前移动
                    array[j--] = array[i];
                }
            }
            // 由于在换位置的时候直接覆盖位置，那么基数被抛弃了，所以将基数放到指针的位置（当时前后指针是相同的）
            array[i] = temp;
            // 递归调用排序方法，从指针位置分成了左右两个数组，再分别对两个数组进行排序
            quickSort(array, l, i -1);
            quickSort(array, i + 1, r);
        }
    }

    /**
     * 插入排序
     * 插入排序是一个稳定算法
     * 时间复杂度是 O(n^2)    因为双层循环
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i ++) {
            for (int j = i; j > 0; j --) {
                if(array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * 希尔排序是一个不稳定排序
     * 时间复杂度是O(nlog2n)--O(n^2)
     * @param array
     */
    public static void shellSort(int[] array) {

        // 外层循环增量
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
            // 内层循环遍历的位置 从增量位置开始换
            for(int i = gap; i < array.length; i ++) {
                // 比较并置换
                int j = i;
                while (j - gap >= 0 && array[j] < array[j - gap]) {
                    swap(array, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 堆排序
     * 堆排序是一个非稳定排序
     * 时间复杂度是O(nlogn)
     * @param array
     */
    public static void heapSort(int[] array) {
        int lastIndex = array.length - 1;
        while(lastIndex > 0) {
            // 从最后一个非叶子节点开始建堆
            for(int i = lastIndex / 2 - 1; i >= 0; i --) {
                heapify(array, i, lastIndex);
            }
            // 上面执行完之后会将最大的放到堆顶
            // 交换堆顶和最后一个节点位置
            swap(array, 0, lastIndex);
            // 再次执行剩余的节点
            lastIndex --;
        }
    }

    /**
     * 构建堆的方法
     * @param array
     * @param i
     * @param lastIndex
     */
    private static void heapify(int[] array, int i, int lastIndex) {
        int max = i;
        // 判断是否有左子结点 并且左子节点比父节点大
        if(2 * i + 1 <= lastIndex && array[2 * i + 1] > array[max]) {
            // 将下标换成左子结点
            max = 2 * i + 1;
        }
        // 判断是否有右子结点
        if(2 * i + 2 <= lastIndex && array[2 * i + 2] > array[max]) {
            // 将下标换成右子结点
            max = 2 * i + 2;
        }
        // 如果最大结点不是父结点 进行交换
        if(max != i) {
            swap(array, i, max);
            heapify(array, max, lastIndex);
        }
    }

    /**
     * 归并排序 迭代法
     * 归并排序是一个稳定排序
     * 时间复杂度是O(nlogn)
     * @param array
     */
    public static void mergeSort(int[] array, int low, int hight) {
        if(low < hight) {
            int mid = (low + hight) / 2;
            // 对左侧进行排序
            mergeSort(array, low, mid);
            // 对右侧进行排序
            mergeSort(array, mid + 1, hight);
            // 进行合并
            merge(array, low, mid, hight);
        }
    }

    /**
     * 合并方法
     */
    public static void merge(int[] array, int low, int mid, int hight) {
        // 将比较的数据放到临时数组中
        int[] temp = new int[array.length];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 只要一边的数据没有到结尾就进行比较
        while (i <= mid && j <= hight) {
            // 如果左边的比右边的小    将左边的放入临时数组 并移动下标
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else { // 同理  相反
                temp[k++] = array[j++];
            }
        }
        // 假如左边还有剩余 将一次性放入
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= hight) {
            temp[k++] = array[j++];
        }
        // 将临时数组中的数据 放入到数组中
        k = 0;
        while (low <= hight) {
            array[low++] = temp[k++];
        }
    }

    /**
     * 计数排序
     * 计数排序是一个稳定的排序方法
     * 时间复杂度是O(n+k) k 数据的范围
     * 适用于有有限范围的数据排序，要求输入的数据必须是有确定范围的整数
     * @param array
     */
    private static void countSort(int[] array) {
        // 找到最大值 并找到最小值：做为偏移量
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i ++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }

        // 创建计数数组
        int[] count = new int[max - min + 1];
        // 进行计数统计
        for (int k : array) {
            count[k - min]++;
        }
        int j = 0;
        // 输出排序到数组中
        for (int i = 0; i < count.length; i ++) {
            while (count[i] > 0) {
                array[j++] = i + min;
                count[i] --;
            }
        }
    }

    /**
     * 桶排序
     * 桶排序稳定性取决于桶内排序使用的排序算法
     * 时间复杂度是O(n)  基于桶内排序的时间复杂度
     * @param array
     */
    public static void bucketSort(int[] array) {
        // 确定最大最小值
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i ++) {
            if(array[i] > max) {
                max = array[i];
            }
            if(array[i] < min) {
                min = array[i];
            }
        }
        // 用最大最小值确定桶的数量
        int size = (max - min) / array.length + 1;
        List<ArrayList<Integer>> buckets = new ArrayList<>();
        // 初始化桶容器
        for (int i = 0; i < size; i ++) {
            buckets.add(new ArrayList<>());
        }
        // 向桶内放数据
        for (int j : array) {
            buckets.get((j - min) / array.length).add(j);
        }
        int k = 0;
        // 对桶内的数据进行排序， 桶内排序算法可以随便使用, 为了方便直接使用 Collections 排序。并对所有的桶进行输出
        for (ArrayList<Integer> bucket : buckets) {
            // 桶内排序
            Collections.sort(bucket);
            // 对桶输出
            for (Integer i : bucket) {
                array[k++] = i;
            }
        }
    }

    /**
     * 基数排序
     * 基数排序是一个稳定排序算法
     * 时间复杂度是O(N * M) M为数据的位数
     * @param array
     */
    public static void radixSort(int[] array) {
        // 找到数组中的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i ++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        // 循环计算不同位的排序
        for (int exp = 1; max / exp > 0 ; exp *= 10) {
            // 创建桶
            int[] buckets = new int[10];
            // 创建临时数组
            int[] temp = new int[array.length];
            // 计算每个桶中的数据
            for (int i = 0; i < array.length; i ++) {
                buckets[array[i] / exp % 10] ++;
            }
            // 对桶中的数据进行累加
            for (int i = 1; i < buckets.length; i ++) {
                buckets[i] += buckets[i - 1];
            }
            // 从后向前遍历原始数组 向temp放入
            for (int i = array.length - 1; i > -1;  i --) {
                int index = array[i] / exp % 10;
                temp[buckets[index] - 1] = array[i];
                // 并将桶中的值减1
                buckets[index] --;
            }
            // 将临时数组中拍好序的数据覆盖到原始数组中
            System.arraycopy(temp, 0, array, 0, array.length);
        }
    }

    /**
     * 交换方法
     * @param array
     * @param i     需要交换的两个位置
     * @param j
     */
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数据
     */
    private static void outPut() {
        System.out.println(Arrays.toString(arrays));
    }
}
