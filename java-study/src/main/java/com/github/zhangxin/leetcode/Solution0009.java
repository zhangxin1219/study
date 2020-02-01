package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 09:39
 * @Description: 回文数
 */
public class Solution0009 {
    // 字符串
    public boolean isPalindrome1(int x) {
        String str = x + "";
        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            char p = str.charAt(i), q = str.charAt(len - i - 1);
            if (p != q)
                return false;
        }
        return true;
    }

    // 反转一般数字
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (x == y || x == y / 10)
            return true;
        else
            return false;
    }

    @Test
    public void test() {
        int x = 121;
        System.out.println(isPalindrome2(x));
    }
}
