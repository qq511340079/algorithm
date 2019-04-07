package com.yyy.dp;

/**
 * @author : ytw
 * @date : 2019-04-05
 * description :斐波拉契数列
 **/
public class FibonacciSequence {

    public static void main(String[] args) {
        int n = 5;
        int result = 0;
        if (n > 0) {
            //result = doRecursion(n);
            //result = dpMemo(n);
            result = doDpFromDown2Up(n);
        }
        System.out.println(result);
    }

    public static int doRecursion(int n) {
        return n <= 1 ? n : doRecursion(n - 1) + doRecursion(n - 2);
    }


    public static int dpMemo(int n){
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return doDpMemo(n, memo);
    }
    /**
     * 动态规划，自顶向下备忘录法
     */
    public static int doDpMemo(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n <= 2) {
            memo[n] = 1;
        } else {
            memo[n] = doDpMemo(n - 1, memo) + doDpMemo(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 动态规划，自底向上
     * */
    public static int doDpFromDown2Up(int n){
        if (n <= 0) {
            return 0;
        }
        int memo_i_1 = 1;
        int memo_i_2 = 0;
        int memo_i = 1;
        for (int i = 2; i <= n; i++) {
            memo_i = memo_i_1 + memo_i_2;
            memo_i_2 = memo_i_1;
            memo_i_1 = memo_i;
        }
        return memo_i;
    }
}
