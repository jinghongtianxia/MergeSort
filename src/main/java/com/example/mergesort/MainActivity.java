package com.example.mergesort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //    private static int[] UNSORTED = {37, 32, 41, 1, 58, 25, 64, 97, 133, 254, 11, 19, 10, 54, 66, 3};
//    private static int[] UNSORTED = {37, 32, 41, 1, 58, 25, 64, 97, 133, 254};
//    private static int[] UNSORTED = {10, 7, 13, 5, 24, 17, 8, 3, 35, 30, 58, 40, 88, 65};
//    private static int[] UNSORTED = {4,2,5,1,3,55,43,7,49,68,32,40,113,652,183,746,132,554,861,941,221,568,977,465,668};
    private static int[] UNSORTED = {4,2,5,1,3,55,43,7,49};
    private int i;
    private int b;

    //九九乘法表
    public static void m(int i) {
        if (i == 1) {
            System.out.println("1*1=1 ");
        } else {
            m(i - 1);
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + " ");
            }
            System.out.println();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        FenChuLai(UNSORTED);
//        FenChuLai(883);
//        System.out.println(factorial(6));
//        m(9);
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(UNSORTED);
        Test test = new Test();
        test.inputArray(UNSORTED);
//        FenChuLai fenChuLai = new FenChuLai();
//        fenChuLai.divide(UNSORTED);
//        MergeSortDemo mergeSortDemo = new MergeSortDemo();
//        mergeSortDemo.inputArray(UNSORTED);
    }

    public void divide(int num) {
        if (num == 1) {
            System.out.println(num);
        } else {
            int key = num >> 1;
            System.out.println(key);
            divide(key);
            System.out.println("kk");
        }
    }

    //递归实现阶乘方法1
    public int factorial(int i) {
        if (i <= 1) {
            return 1;
        } else {
            System.out.println(i);
            return i * factorial(i - 1);
        }
    }


}
