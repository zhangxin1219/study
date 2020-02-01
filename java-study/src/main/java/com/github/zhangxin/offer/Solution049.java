package com.github.zhangxin.offer;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/21 18:30
 * @Description:
 */
public class Solution049 {
    public int StrToInt(String str) {
        if (str == null || str.length() <= 0)
            return 0;
        int flag = 1;
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-') {
                flag = -1;
                continue;
            } else if (i == 0 && str.charAt(i) == '+') {
                continue;
            }
            char current = str.charAt(i);
            if (current < '0' || current > '9') {
                return 0;
            }
            result = result * 10 + (current - '0');
            if ((flag == 1 && result > Integer.MAX_VALUE) || (flag == -1 && flag * result < Integer.MIN_VALUE)) {
                return 0;
            }
        }
        return flag * (int) result;
    }

    @Test
    public void test() {
        Solution049 solution049 = new Solution049();
        int result = solution049.StrToInt("+2147483647");
        System.out.println(result);
    }
}
