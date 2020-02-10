package com.github.zhangxin.mianjing;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/10 17:26
 * @Description:
 */
public class Solution0002 {
    public static void main(String[] args) {
        Integer x = 1500;
        Object y = x;
        f(x);
        f(y);
        System.out.println(x==y);
    }

    public static void f(Object o){
        System.out.println("Object: "+o);
    }

    public static void f(Integer i){
        System.out.println("Integer: "+i);
    }
}
