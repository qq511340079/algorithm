package com.yyy;

/**
 * @author ytw
 * @date 2019/6/26
 * description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,10,20,21,99,100};
        int result = binarySearch(arr, 0, arr.length, 5);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int fromIndex, int toIndex, int target){
        int leftIndex = fromIndex;
        int rightIndex = toIndex - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) >>> 1;
            if (arr[midIndex] == target) {
                return midIndex;
            }else if(arr[midIndex] < target){
                leftIndex = midIndex + 1;
            }else {
                rightIndex = midIndex - 1;
            }
        }
        return -1;
    }
}
