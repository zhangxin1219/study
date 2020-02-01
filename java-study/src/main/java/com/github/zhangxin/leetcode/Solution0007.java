package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 13:29
 * @Description: 整数反转
 */
public class Solution0007 {
    @Deprecated()
    // 字符串转换效率太低
    public int reverse1(int x) {
        if (x == 0) return x;
        String s = x + "";
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if ("0".equals(s.charAt(length - 1 - i)))// 去除末尾0
                continue;
            if (x < 0 && i == 0) // 判断正负
                sb.append("-");
            if (x < 0 && i == length - 1)
                continue;
            sb.append(s.charAt(length - 1 - i));
        }
        Long temp = Long.valueOf(sb.toString());
        return (temp >= Integer.MIN_VALUE && temp <= Integer.MAX_VALUE) ? temp.intValue() : 0;
    }

    public int reverse2(int x) {
        int answer = 0;
        while (x != 0) {
            int pop = x % 10;
            if (answer > Integer.MAX_VALUE / 10 || (answer == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (answer < Integer.MIN_VALUE / 10 || (answer < Integer.MIN_VALUE / 10) && pop < -8)
                return 0;
            answer = answer * 10 + pop;
            x = x / 10;
        }
        return answer;
    }

    @Test
    public void test() {
        System.out.println(reverse2(-1320));
    }
}
