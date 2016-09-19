package com.example.mergesort;

import java.util.Arrays;

/**
 * Created by king on 2016/9/17.
 */
public class FenChuLai {

//    private int[] ARRAY_ONE;


    //{10, 7, 13, 5, 24, 17, 8, 3, 35, 30, 58, 40, 88, 65}
    public void divide(int[] array) {
        for (int gap = 1; gap < array.length; gap = (gap << 1)) {
            int i = 0;
            int k = 0;
            int j = i + gap;
            for (int y = 0; y < array.length; y = ((gap << 1) + y)) {
                int[] ARRAY_ONE = new int[gap << 1];
//            for (int i = 0; i < gap; i=i+4)
                int l = y;
                int b = y + gap;
                int n = 0;
                while (l < y + gap && b < y + (gap << 1)) {
                    if (array[l] < array[b]) {
                        ARRAY_ONE[n] = array[l];
                        l++;
                        n++;
                    } else {
                        ARRAY_ONE[n] = array[b];
                        b++;
                        n++;
                    }
                }
                if (b >= (y + (gap << 1)) - 1) {
//                    ARRAY_ONE[i + j + 1] = array[i];
                    for (int m = n, r = l; m < ARRAY_ONE.length; m++, r++) {
                        ARRAY_ONE[m] = array[r];
                    }
                }
                if (l > (y + gap - 1)) {
                    for (int m = n, r = b; m < ARRAY_ONE.length; m++, r++) {
                        ARRAY_ONE[m] = array[r];
                    }
                }
                int g = y;
                for (int z = 0; z <= gap; z++) {
                    array[g] = ARRAY_ONE[z];
                    g++;
                }
                System.out.println(Arrays.toString(ARRAY_ONE));
            }
        }
    }
}
