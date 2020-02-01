package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 15:26
 * @Description: 报数
 */
public class Solution0038 {
    public String countAndSay(int n) {
        if (n < 1 || n > 30)
            return "";
        if (n == 1)
            return "1";
        else {
            String before = countAndSay(n - 1);
            char first = before.charAt(0);
            StringBuilder sb = new StringBuilder();
            int k = 1, lenOfBefore = before.length();
            for (int i = 1; i < lenOfBefore; i++) {
                if (before.charAt(i) != first) {
                    sb.append(k).append(first);
                    first = before.charAt(i);
                    k = 1;
                } else {
                    k++;
                }
            }
            sb.append(k).append(before.charAt(lenOfBefore - 1));
            return sb.toString();
        }
    }

    @Test
    public void test() {
        System.out.println(countAndSay(6));
    }
}
