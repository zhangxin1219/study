package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 19:12
 * @Description:
 */
public class ThreadInterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ){}
            }
        });
        threadA.start();
        threadA.interrupt();
        System.out.println(threadA.isInterrupted());
        System.out.println(threadA.interrupted());//实例对象也可以调用静态方法, 等于直接类调用静态方法
        System.out.println(Thread.interrupted());
        System.out.println(threadA.isInterrupted());
        threadA.join();
        System.out.println("end");
    }
}
