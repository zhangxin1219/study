package com.github.zhangxin.concurrent;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/13 20:58
 * @Description:
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> variable = new ThreadLocal<>();

    public static void print(String string) {
        System.out.println(string + variable.get());
        variable.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                variable.set("threadA local variable");
                print("threadA");
                System.out.println("threadA remove after: " + variable.get());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                variable.set("threadB local variable");
                print("threadB");
                System.out.println("threadB remove after: " + variable.get());
            }
        });
        threadA.start();
        threadB.start();
    }
}
