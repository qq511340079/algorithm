package com.yyy.thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author : ytw
 * @date : 2019-03-27
 * description :
 **/
public class CountDownLatchDemo {

    public static int num = 5;
    public static CountDownLatch countDownLatch = new CountDownLatch(num);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < num; i++) {
                try {
                    Thread.sleep(500L);
                    System.out.println("countDown");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            Thread t2 = new Thread(()->{
                try {
                    System.out.println("t2线程进入等待");
                    countDownLatch.await();
                    System.out.println("t2线程继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t2.start();
            System.out.println("main线程进入等待");
            countDownLatch.await();
            System.out.println("main线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
