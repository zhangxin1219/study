package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 10:17
 * @Description: 整数转罗马数字
 */
public class Solution0012 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while (i < 13) {
            while (num >= nums[i]) {
                num -= nums[i];
                ans.append(romans[i]);
            }
            i++;
        }
        return ans.toString();
    }

    @Test
    public void test() {
        System.out.println(intToRoman(58));
    }
}
