package com.yyy.sort.quick;

import java.util.Arrays;

/**
 * @author : ytw
 * @date : 2019-01-11
 * description :快速排序
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] waitSortArr = {1, 6, 7, 12, 4, 0, 11, 31, 2, 7, 5, 4, 7, 8, 0};
        sort(waitSortArr, 0, waitSortArr.length - 1);
        System.out.println(Arrays.toString(waitSortArr));
    }

    private static void sort(int[] waitSortArr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int initLeft = leftIndex, initRight = rightIndex;
        int base = waitSortArr[leftIndex];
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && waitSortArr[rightIndex] > base) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                waitSortArr[leftIndex++] = waitSortArr[rightIndex];
            }
            while (leftIndex < rightIndex && waitSortArr[leftIndex] < base) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                waitSortArr[rightIndex--] = waitSortArr[leftIndex];
            }
        }
        waitSortArr[leftIndex] = base;
        sort(waitSortArr, initLeft, leftIndex - 1);
        sort(waitSortArr, leftIndex + 1, initRight);
    }
}
