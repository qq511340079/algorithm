package com.yyy.sort.bubble;

import java.util.Arrays;

/**
 * @author : ytw
 * @date : 2019-01-11
 * description :
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] waitSortArr = {1, 3, 2, 4, 0, 5, 1, 12, 21, 11, 9, 10};
        for (int i = 0; i < waitSortArr.length - 1; i++) {
            for (int j = 0; j < waitSortArr.length - 1 - i; j++) {
                if (waitSortArr[j] > waitSortArr[j + 1]) {
                    int temp = waitSortArr[j];
                    waitSortArr[j] = waitSortArr[j + 1];
                    waitSortArr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(waitSortArr));
    }
}
