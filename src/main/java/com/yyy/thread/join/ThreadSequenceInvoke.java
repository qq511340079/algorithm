package com.yyy.thread.join;

/**
 * @author : ytw
 * @date : 2019-03-27
 * description : 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 **/
public class ThreadSequenceInvoke {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                System.out.println("t2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
                System.out.println("t3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
