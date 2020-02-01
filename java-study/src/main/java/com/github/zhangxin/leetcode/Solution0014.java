package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 12:56
 * @Description: 最长公共前缀
 */
public class Solution0014 {
    public String longestCommonPrefix(String[] strs) {
        int lenOfStrs = strs.length;
        if (lenOfStrs == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < lenOfStrs; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return "";
        }
        return ans;
    }

    @Test
    public void test() {
        String[] strs = {"abc", "abcd", "ab","dasd"};
        System.out.println(longestCommonPrefix(strs));
    }
}
