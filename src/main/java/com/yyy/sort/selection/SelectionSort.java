package com.yyy.sort.selection;

import java.util.Arrays;

/**
 * @author : ytw
 * @date : 2019-01-11
 * description :选择排序，时间复杂度O(n²)
 **/
public class SelectionSort {

    public static void main(String[] args) {
        int[] waitSortArr = {6, 54, 123, 5, 4, 0, 1, 3, 65, 7, 888, 13, 4576, 5};
        for (int i = 0; i < waitSortArr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < waitSortArr.length; j++) {
                if (waitSortArr[index] > waitSortArr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = waitSortArr[i];
                waitSortArr[i] = waitSortArr[index];
                waitSortArr[index] = temp;
            }
        }
        System.out.println(Arrays.toString(waitSortArr));
    }
}
