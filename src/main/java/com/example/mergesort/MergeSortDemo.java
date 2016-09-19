package com.example.mergesort;

/**
 * Created by king on 2016/9/16.
 */
public class MergeSortDemo {

    public void inputArray(int[] array) {
        //从最小的长度为1的数组开始合并
        for (int gap = 1; gap < array.length; gap = gap << 1) {
            divide(array,gap);
        }
    }

    public void divide(int[] array, int gap) {
        int l = 0;
        int h = l + gap;
        int[] newArray = new int[gap<<1];
        int k = 0;
        while ((l <= (gap - 1)) && (h <= (gap << 1) - 1)) {
            if (array[l] < array[h]) {
                newArray[k] = array[l];
                l++;
                k++;
            }else {
                newArray[k]=array[h];
                h++;
                k++;
            }
        }

        while (l<=gap){
            newArray[k]=array[l];
            l++;
            k++;
        }
        while (h<=(gap<<1)){
            newArray[k]=array[h];
            h++;
            k++;
        }
    }

}
