package com.yyy.thread.juc;

import java.util.concurrent.*;

/**
 * @author : ytw
 * @date : 2019-03-27
 * description :
 **/
public class CyclicBarriarDemo {

    public static int num = 5;
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(num);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(num, num, 60, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < num * 3; i++) {
            Thread.sleep(1000L);
            es.execute(()->{
                try {
                    System.out.println("线程进入等待");
                    cyclicBarrier.await();
                    System.out.println("线程继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();

    }
}
