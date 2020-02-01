package com.github.zhangxin.jvm;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/29 13:39
 * @Description:
 */
public class JVMTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println((double) Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println((double) Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.gc();
    }
}
