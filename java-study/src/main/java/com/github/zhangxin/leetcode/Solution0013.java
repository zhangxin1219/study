package com.github.zhangxin.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 10:37
 * @Description: 罗马数字转整数
 */
public class Solution0013 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int before = map.get(s.charAt(i));
            int after = map.get(s.charAt(i + 1));
            if (before >= after)
                ans += before;
            else
                ans -= before;
        }
        ans += map.get(s.charAt(s.length() - 1));
        return ans;
    }

    @Test
    public void test() {
        System.out.println(romanToInt("LVIII"));
    }
}
