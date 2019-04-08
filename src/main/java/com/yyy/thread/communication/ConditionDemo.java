package com.yyy.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : ytw
 * @date : 2019-03-27
 * description :
 **/
public class ConditionDemo {


    public static void main(String[] args) {
        Product product = new Product();
        Thread producer = new Thread(() -> {
            while (true) {
                product.product();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                product.consumer();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }

    static class Product {
        private int count;

        private Lock lock = new ReentrantLock();

        Condition notFull = lock.newCondition();

        Condition notEmpty = lock.newCondition();

        public void product() {
            try {
                lock.lock();
                while (count == 10) {
                    notFull.await();
                }
                count++;
                System.out.println("producer生产了" + count);
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void consumer() {
            try {
                lock.lock();
                while (count == 0) {
                    notEmpty.await();
                }
                System.out.println("consumer消费了" + count--);
                notFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
