package com.github.zhangxin.offer;

import org.junit.Test;

import java.util.Stack;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/11 14:12
 * @Description:
 */
public class SolutionTest {
    public class Number {
        public Integer integer = 10000;
    }

    public void modify(Integer n) {
        n = 20000;
    }

    @Test
    public void test() {
//        Number number = new Number();
//        System.out.println(number.integer);
//        modify(number.integer);
//        System.out.println(number.integer);
        Integer n1 = new Integer(123);
        Integer n2 = new Integer(123);
        System.out.println(n1 != n2);
        Stack[] stacks = new Stack[2];
    }
}
