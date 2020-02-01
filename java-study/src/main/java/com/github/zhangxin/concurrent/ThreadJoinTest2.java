package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 14:45
 * @Description:
 */
public class ThreadJoinTest2 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    boolean a = true;
                }
            }
        });
        Thread mainThread = Thread.currentThread();
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });
        threadA.start();
        threadB.start();
        try{
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
