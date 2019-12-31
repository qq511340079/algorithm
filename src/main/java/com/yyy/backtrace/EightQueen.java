package com.yyy.backtrace;

import java.util.Arrays;

/**
 * @author ytw
 * @date 2019/7/3
 * description: 八皇后问题
 */
public class EightQueen {

    private static int[] chessboard = new int[8];
    private static int count = 0;

    public static void main(String[] args) {
        eightQueen(0);
        System.out.println(count);
    }

    private static void eightQueen(int row) {
        if (row > 7) {
            count++;
            System.out.println(Arrays.toString(chessboard));
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (!check(row, col)) {
                continue;
            }
            chessboard[row] = col;
            eightQueen(row + 1);
            chessboard[row] = 0;
        }
    }

    private static boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i] == col || (i + 1 == row && chessboard[i] + 1 == col) || (i + 1 == row && chessboard[i] - 1 == col)) {
                return false;
            }
        }
        return true;
    }

}
