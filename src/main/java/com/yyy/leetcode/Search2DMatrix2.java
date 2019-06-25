package com.yyy.leetcode;


/**
 * 搜索二维矩阵II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class Search2DMatrix2 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 6, 10, 13, 14, 16, 21}, {3, 10, 12, 18, 22, 27, 29}, {3, 15, 19, 20, 23, 29, 34}, {8, 15, 19, 25, 27, 29, 39}, {12, 17, 24, 25, 28, 29, 41}, {16, 22, 27, 31, 31, 33, 44}, {20, 26, 28, 35, 39, 41, 45}, {25, 31, 34, 39, 44, 45, 47}};
        boolean result = searchMatrix(matrix, 1);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target){
        if (matrix.length == 0){
            return false;
        }
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
            int num = matrix[i][j];
            if (num == target) return true;
            if (num < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
