package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 16:09
 * @Description: Pow(x, n)
 */
public class Solution0050 {
    // 暴力法
    public double myPow1(double x, int n) {
        if (n == 0)
            return 1;
        double ans = x;
        if (n > 0) {
            while (n > 1) {
                ans *= x;
                n--;
            }
        } else {
            ans = 1 / x;
            while (n < -1) {
                ans /= x;
                n++;
            }
        }
        return ans;
    }

    // 迭代
    public double myPow2(double x, int n) {
        if (x == -1) {
            if ((n % 2) == 1)
                return -1;
            else
                return 1;
        }
        if (x == 1)
            return 1;
        if (n == -2147483648)
            return 0;
        if (n > 0) {
            return powIteration(x, n);
        } else
            return 1 / powIteration(x, -n);
    }

    public double powIteration(double x, int n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                ans *= x;
            x = x * x;
            n = n >> 1;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(myPow2(3, -2));
    }
}
