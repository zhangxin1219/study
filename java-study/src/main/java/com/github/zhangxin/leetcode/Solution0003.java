package com.github.zhangxin.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 13:00
 * @Description: 无重复字符的最长子串
 */
public class Solution0003 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j)))
                i = map.get(s.charAt(j)) > i ? map.get(s.charAt(j)) : i;
            map.put(s.charAt(j), j + 1);
            answer = Math.max(answer, j - i + 1);
        }
        return answer;
    }

    @Test
    public void test() {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
