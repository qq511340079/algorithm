package com.yyy.thread;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ytw
 * @date : 2019-04-05
 * description :
 **/
public class PrintABC {

    public static volatile Boolean flagA = true;
    public static volatile Boolean flagB = false;
    public static volatile Boolean flagC = false;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        PrintABC monitor = new PrintABC();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (!flagA) {
                        try {
                            a.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    flagA = false;
                    flagB = true;
                    b.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                try{
                    lock.lock();
                    while (!flagB) {
                        try {
                            b.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("b");
                    flagB = false;
                    flagC = true;
                    c.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(2);
        });
        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                try{
                    lock.lock();
                    while (!flagC) {
                        try {
                            c.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("c");
                    flagC = false;
                    flagA = true;
                    a.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println(3);
        });
        t1.start();
        t2.start();
        t3.start();
    }
}