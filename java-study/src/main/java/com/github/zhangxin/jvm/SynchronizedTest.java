package com.github.zhangxin.jvm;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/20 18:24
 * @Description:
 */

class A {
    public synchronized static void f() {
        System.out.println("static method");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static method end");
    }

    public synchronized  void f1() {
        System.out.println(" method1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1 end");
    }

    public synchronized  void f2() {
        System.out.println(" method2");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method2 end");
    }
}

public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
                a.f2();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
                a.f1();
            }
        });
        thread2.start();
        thread1.start();
        Thread.sleep(20000);
    }
}
