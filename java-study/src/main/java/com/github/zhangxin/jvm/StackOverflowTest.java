package com.github.zhangxin.jvm;

import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/28 20:27
 * @Description:
 */
public class StackOverflowTest {
    public static void main(String[] args) {
        m();
    }

    public static void m() {
        m();
    }
}
