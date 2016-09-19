package com.example.mergesort;

import java.util.Arrays;

/**
 * 最终完成版
 * Created by king on 2016/9/18.
 */

/**
 * 该算法算是结构比较难的算法，学习过程收获很多。
 */
public class Test {

    public void inputArray(int[] array) {
        for (int gap = 1; gap < array.length; gap = gap << 1) {
            divide(array, gap);
        }
    }

    public void divide(int[] array, int gap) {
        int i;

        for (i = 0; i + (gap << 1) - 1 < array.length; i = i + (gap << 1)) {
            //参数分别是，数组，第一段数组初始值，第一段数组末尾，第二段数组末尾
            merge(array, i, i + gap - 1, i + (gap << 1) - 1);
        }

        //如果i+gap-1<length<i+2gap-1,则应分成1个gap+1个短数组
        if (i + gap - 1 < array.length) {
            merge(array, i, i + gap - 1, array.length - 1);
        }
    }

    public void merge(int[] array, int firstInit, int firstEnd, int secondEnd) {

        //第一段初始
        int f = firstInit;

        //第二段初始
        int b = firstEnd + 1;

        //临时数组的下标
        int k = 0;

        //临时数组
        int[] createArray = new int[secondEnd - firstInit + 1];

        //两个数组对应的数进行对比，较小的放入临时数组
        while (f <= firstEnd && b <= secondEnd) {
            if (array[f] < array[b]) {
                createArray[k] = array[f];
                f++;
                k++;
            } else {
                createArray[k] = array[b];
                b++;
                k++;
            }
        }

        //如果第一个数组清空了,第二个数组未清空，则把第二个数组剩下的数字放入临时数组,直到第二个数组也清空了。
        while (b <= secondEnd) {
            createArray[k] = array[b];
            b++;
            k++;
        }

        //如果第二个数组清空了，第一个数组未清空，则把第二个数组剩下的数字放入临时数组，直到第一个数组也清空了。
        while (f <= firstEnd) {
            createArray[k] = array[f];
            f++;
            k++;
        }

        //把临时数组中的数字放入原数组
        for (k = 0, f = firstInit; f <= secondEnd; f++, k++) {
            array[f] = createArray[k];
        }

        System.out.println(Arrays.toString(array));
    }

}
