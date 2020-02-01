package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 13:09
 * @Description:
 */
public class ThreadWaitInterruptTest {
    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (object) {
                        object.wait();
                    }
                    System.out.println("==end==");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(100);
        System.out.println("begin interrupt threadA");
        threadA.interrupt();
        System.out.println("end interrupt threadA");
    }
}
