package com.yyy.leetcode;

import java.util.Arrays;

/**
 * @author ytw
 * @date 2019/6/25
 * description: 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [1,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Index = nums1.length - 1;
        for (int i = n-1; i >= 0; ) {
            //m <= 0为了判断nums1是长度为1的空数组的情况，和nums1数组中的元素都合并完了的情况(此时只用把num2数组的元素直接放到nums1即可)
            if (m <= 0 || nums2[i] >= nums1[m - 1]) {
                nums1[num1Index] = nums2[i];
                i--;
            }else {
                nums1[num1Index] = nums1[m - 1];
                m--;
            }
            num1Index--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[1];
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

}
