package com.yyy.leetcode;

import java.util.Arrays;

/**
 * @author ytw
 * @date 2019/6/25
 * description:求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {


    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int num1 = nums[i];
            if (num == num1) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                num = num1;
                count++;
            }
        }
        return num;
    }

    /**
     * 解法2：
     * 因为众数的定义：给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 所以对一个有序的数组来讲众数肯定是数组长度的一半+1的那个索引位置的数
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int result = majorityElement2(nums);
        System.out.println(result);
    }

}
