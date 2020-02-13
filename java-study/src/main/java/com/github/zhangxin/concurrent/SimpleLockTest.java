package com.github.zhangxin.concurrent;

import java.util.Hashtable;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/13 14:26
 * @Description:
 */
public class SimpleLockTest {
    final static SimpleLock simpleLock = new SimpleLock();
    final static Condition notFull = simpleLock.newCondition();
    final static Condition notEmpty = simpleLock.newCondition();

    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                simpleLock.lock();
                try {
                    while (queue.size() == queueSize) {
                        System.out.println("producer " +Thread.currentThread()+ " notEmpty.await();");
                        notEmpty.await();
                    }
                    queue.add("ele");
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    simpleLock.unlock();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                simpleLock.lock();
                try {
                    while (0 == queue.size()) {
                        System.out.println("consumer " +Thread.currentThread()+ " notFull.await();");
                        notFull.await();
                    }
                    String ele = queue.poll();
                    System.out.println(Thread.currentThread()+ele);
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    simpleLock.unlock();
                }
            }
        });
        consumer.start();
        Thread.sleep(500);
        producer.start();

    }
}
