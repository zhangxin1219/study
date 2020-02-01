package com.github.zhangxin.jvm;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/12/28 09:46
 * @Description:
 */
public class ConstantPoolTest {
    public static void main(String[] args) {
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);// 输出 true
        Integer i3 = new Integer(33);
        Integer i4 = new Integer(33);
        System.out.println(i3 == i4);// 输出false
        Integer i11 = 333;
        Integer i22 = 333;
        System.out.println(i11 == i22);// 输出 false
        Double d1 = 1.2;
        Double d2 = 1.2;
        System.out.println(d1 == d2);// 输出 false
    }
}
