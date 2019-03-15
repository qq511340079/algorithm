package com.yyy.sort.heap;

import java.util.Arrays;

/**
 * @author : ytw
 * @date : 2019-01-14
 * description :堆排序
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] waitSortArr = {3, 1, 5, 7, 0, 2, 46, 18, 2, 11, 6, 8, 9};
        //第一步：初始化建堆，先从最后一个非叶子节点开始构建大根堆，构建完成后就是堆有序(父节点比子节点大)。(waitSortArr.length / 2) - 1 = 二叉堆中最后一个非叶子节点的索引
        for (int i = waitSortArr.length / 2 - 1; i >= 0; i--) {
            sort(waitSortArr, i, waitSortArr.length);
        }
        //第二步：从根节点开始构建大根堆
        for (int i = waitSortArr.length - 1; i > 0; i--) {
            //先把之前的构建结果交换到二叉堆的末尾
            swap(waitSortArr, 0, i);
            //再继续从根节点构建大根堆
            sort(waitSortArr, 0, i);
        }
        System.out.println(Arrays.toString(waitSortArr));
    }

    /**
     * 从小到大的顺序排序，所以构建大根堆
     * 每次交换时都需要确保被交换的子节点被当做父节点时仍然比其子节点大，所以循环比较，比较完成后就可以确保每个父节点都比子节点大(堆有序)。如果不循环比较的话就无法保证子节点路径上的值一定比兄弟节点路径上的值大。
     * 循环中的childNodeIndex = childNodeIndex * 2 + 1是重点，当发生元素交换时需要循环比较
     *
     * @param k 父节点的索引
     * @length 未排序的二叉堆的长度
     */
    public static void sort(int[] arr, int k, int length) {
        int temp = arr[k];
        //k * 2 + 1 = 左子节点的索引，childNodeIndex = k * 2 + 1 = 尝试修正被交换的子节点为的父节点的节点的，如果没有子节点了则不满足childNodeIndex < length，就不会继续循环
        for (int childNodeIndex = k * 2 + 1; childNodeIndex < length; childNodeIndex = childNodeIndex * 2 + 1) {
            //比较左右子节点哪个更大
            if (childNodeIndex + 1 < length && arr[childNodeIndex + 1] > arr[childNodeIndex]) {
                childNodeIndex++;
            }
            //如果子节点比父节点大，则交换
            if (temp < arr[childNodeIndex]) {
                swap(arr, childNodeIndex, k);
                //交换后，则可能被交换的子节点的子节点的顺序被打乱，则需要循环修正，即childNodeIndex = k * 2 + 1
                k = childNodeIndex;
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
