package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 20:56
 * @Description: 两数相除
 */
public class Solution0029 {
    public int divide(int dividend, int divisor) {
        boolean sign = !(dividend > 0 ^ divisor > 0);
        if (dividend > 0)
            dividend = -dividend;
        if (divisor > 0)
            divisor = -divisor;
        int count = 0, ans = 0;
        while (divisor >= dividend) {
            divisor = divisor << 1;
            count += 1;
            if (divisor <= Integer.MIN_VALUE) break;
        }
        while (count > 0) {
            count -= 1;
            divisor = divisor >> 1;
            if (dividend <= divisor) {
                dividend -= divisor;
                ans += 1 << count;
            }
        }
//        if (ans <= Integer.MIN_VALUE && sign)
//            return Integer.MAX_VALUE;
        if (sign) {
            if (ans <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            ans = -ans;
        }
        return sign ? ans : -ans;
    }

    @Test
    public void test() {
        System.out.println(divide(-2147483648, -1));
    }
}
