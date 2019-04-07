package com.yyy.thread.communication;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author : ytw
 * @date : 2019-03-27
 * description :
 **/
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        Thread producer = new Thread(()->{
            int count = 0;
            while (true) {
                try {
                    Thread.sleep(500L);
                    int product = count++;
                    arrayBlockingQueue.put(product);
                    System.out.println("生产了" + product);
                    System.out.println("队列size = " + arrayBlockingQueue.size() );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread producer2 = new Thread(()->{
            int count = 0;
            while (true) {
                try {
                    Thread.sleep(500L);
                    int product = count++;
                    arrayBlockingQueue.put(product);
                    System.out.println("生产了" + product);
                    System.out.println("队列size = " + arrayBlockingQueue.size() );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(1000L);
                    Integer product = arrayBlockingQueue.take();
                    System.out.println("消费了" + product);
                    System.out.println("队列size = " + arrayBlockingQueue.size() );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        producer2.start();
        consumer.start();
    }
}
