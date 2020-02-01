package com.github.zhangxin.jvm;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/27 15:43
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
//        String s1 = new String("he") + new String("llo");     // 1
        char[] a = {'h', 'e', 'l', 'l', 'o'};
        String s1 = new String(a, 0, 5);
//        String s1 = new String("hello");
        String s3 = s1.intern();                                      // 2
        String s4 = s1.intern();
        String s2 = "hello";                                // 3
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s3 == s4);
//        String s1 = new StringBuilder("0").append("1").toString();
//        System.out.println(s1.intern() == s1);  //返回true
//        String s2 = new StringBuilder("2").toString();
//        System.out.println(s2.intern() == s2);  //返回false
    }
}
