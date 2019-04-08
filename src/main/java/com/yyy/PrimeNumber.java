package com.yyy;


/**
 * 输出1-10000的素数
 */
public class PrimeNumber {


    public static void main(String[] args) {
        flag:
        for (int i = 2; i < 10000; i++) {
            //只对小于i的平方根的数判断是否能整除
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue flag;
                }
            }
            System.out.println("素数：" + i);
        }
    }
}
