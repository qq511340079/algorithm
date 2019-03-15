package com.yyy.sort.merge;

import java.util.Arrays;

/**
 * @author : ytw
 * @date : 2019-01-15
 * description :合并排序
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] waitSortArr = {5, 1, 10, 2, 66, 1, 2, 0, 100, 3, 4, 5, 9, 1};
        int[] temp = new int[waitSortArr.length];
        //递归拆分数组，拆分到两个分段中都只有一个元素时则该分段为有序，开始合并
        mergeSort(waitSortArr, 0, waitSortArr.length - 1, temp);
        System.out.println(Arrays.toString(waitSortArr));

    }

    private static void mergeSort(int[] arr, int startIndex, int endIndex, int[] temp) {
        //如果分段中有大于一个元素时继续拆分
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            //使左边是有序的
            mergeSort(arr, startIndex, mid, temp);
            //使右边是有序的
            mergeSort(arr, mid + 1, endIndex, temp);
            //左右两个分段中都已经是有序的了，则合并两个分段
            merge(arr, startIndex, mid, endIndex, temp);
        }
    }

    /**
     * 合并两个分段
     * @param arr 原始数组
     * @param first 左边分段的起始索引
     * @param mid 左右分段分隔的索引，也是左分段的末尾，+1=右分段的开始索引
     * @param last 右分段的结束索引
     * @param temp 临时数组，用来存放合并后的有序元素
     */
    private static void merge(int[] arr, int first, int mid, int last, int[] temp) {
        int k = 0;
        //右分段中的起始索引
        int j = mid + 1;
        //左分段中的开始索引
        int i = first;
        //左右两个分段都还有元素，则继续比较两个分段，直到有一个分段已经合并完成
        while (first <= mid && j <= last) {
            if (arr[first] < arr[j]) {
                temp[k++] = arr[first++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //有一个分段已经合并完成了，则未被合并完成的分段可以不用比较直接合并过去

        while (j <= last) {
            temp[k++] = arr[j++];
        }
        while (first <= mid) {
            temp[k++] = arr[first++];
        }
        //此时temp数组中的0~k的元素就是有序的了，直接回写到原数组中
        for (int n = 0; n < k; n++) {
            arr[i + n] = temp[n];
        }
    }

}

