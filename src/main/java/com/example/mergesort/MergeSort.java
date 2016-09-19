package com.example.mergesort;

import java.util.Arrays;

/**
 * Created by king on 2016/9/16.
 */
public class MergeSort {
//    public static void main(String[] args) {
//        int[] array = {
//                9, 1, 5, 3, 4, 2, 6, 8, 7
//        };
//
//        MergeSort merge = new MergeSort();
//        System.out.print("排序前:\t\t");
//        merge.printAll(array);
//        merge.sort(array);
//        System.out.print("排序后:\t\t");
//        merge.printAll(array);
//    }

    //{10, 7, 13, 5, 24, 17, 8, 3, 35, 30, 58, 40, 88, 65}
    public void Merge(int[] array, int low, int mid, int high) {

        //i=i+gap<<1
        int i = low; // i是第一段序列的下标

        //实际上j=i+gap
        int j = mid + 1; // j是第二段序列的下标


        int k = 0; // k是临时存放合并序列的下标

        //[high-low-1]=[gap<<1]
        int[] array2 = new int[high - low + 1]; // array2是临时合并序列

        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[i] <= array[j]) {
                array2[k] = array[i];
                i++;
                k++;
            } else {
                array2[k] = array[j];
                j++;
                k++;
            }
        }

        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid) {
            array2[k] = array[i];
            i++;
            k++;
        }

        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high) {
            array2[k] = array[j];
            j++;
            k++;
        }

        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = array2[k];
        }
        System.out.println(Arrays.toString(array));
    }

    public void MergePass(int[] array, int gap, int length) {
        int i = 0;

        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            Merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }

        //这里是最后剩余的长度超出一个子表，但是又不够两个子表，所以拆分成两个大小不等的表进行对比。
        //如果连一个子表的长度都没超出，则不进行对比，gap肯定是小于length的，为什么是i + gap - 1<length,而不是i<length，因为只要原始数组长度大于1，则一定可以分出长短
        //相同或者不同的两个数组，而i+gap-1表示的是第一个数组的最后一个数。i+2*gap-1表示的是第二个数组的最后一个数,i+gap-1<length<=i+2gap-1。就表示后面的剩余的数字可
        //以分成1gap+1短。
        // 如果i+gap-1>length，就表示要进入下一个gap。如果i+gap-1<length，就表示可以分成1gap+一短来实现对比。
        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length) {
            Merge(array, i, i + gap - 1, length - 1);
        }
    }

    public int[] sort(int[] list) {
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            MergePass(list, gap, list.length);
//            System.out.print("gap = " + gap + ":\t");
        }
        return list;
    }

    // 打印完整序列
//    public void printAll(int[] list) {
//        for (int value : list) {
//            System.out.print(value + "\t");
//        }
//        System.out.println();
//    }
}
