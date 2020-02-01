package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 13:56
 * @Description:
 */
public class ThreadNotifyTest {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    resourceA.wait();
                    System.out.println("threadA wait end");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    resourceA.wait();
                    System.out.println("threadB wait end");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("threadC begin notify");
                resourceA.notifyAll();
            }
        });

        threadA.start();
        threadB.start();

//        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
    }
}
