package com.github.zhangxin.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/27 12:03
 * @Description:
 */
public class ReferenceTest {
    public static void main(String[] args) {
        String str1 = "1";
        System.out.println(str1);
        String str2 = "2";
        SoftReference<String> softReference = new SoftReference<>(str2);
        System.out.println(softReference.get());
        String str3 = new String("3");
        WeakReference<String> weakReference = new WeakReference<>(str3);
        System.out.println(weakReference.get());
        str3 = null;
        System.gc();
//        System.out.println(str1);
//        System.out.println(softReference.get());
        System.out.println(weakReference.get());

        WeakReference<String> str = new WeakReference<String>(new String("123"));
        System.out.println(str.get()); // 123
        System.out.println(str.getClass()); // class java.lang.ref.WeakReference
        //通知JVM进行内存回收
        System.gc();
        System.out.println(str.get()); //null
    }
}
