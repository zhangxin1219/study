package com.github.zhangxin.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 13:09
 * @Description: 电话号码的字母组合
 */
public class Solution0017 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        List<String[]> letterTable = new ArrayList<>();
        letterTable.add(new String[]{"a", "b", "c"});// 2
        letterTable.add(new String[]{"d", "e", "f"});// 3
        letterTable.add(new String[]{"g", "h", "i"});// 4
        letterTable.add(new String[]{"j", "k", "l"});// 5
        letterTable.add(new String[]{"m", "n", "o"});// 6
        letterTable.add(new String[]{"p", "q", "r", "s"});// 7
        letterTable.add(new String[]{"t", "u", "v"});// 8
        letterTable.add(new String[]{"w", "x", "y", "z"});// 9
        String[] first = letterTable.get(digits.charAt(0) - 48 - 2);
        for (int i = 0; i < first.length; i++) {
            ans.add(first[i]);
        }
        for (int j = 1; j < digits.length(); j++) {
            int num = digits.charAt(j) - 48;
            String[] letters = letterTable.get(num - 2);
            int lenOfNum = letters.length;
            List<String> temp = new ArrayList<>(ans);
            for (int i = 0; i < lenOfNum - 1; i++) {
                ans.addAll(temp);
            }
            for (int k = 0; k < ans.size(); k++) {
                String old = ans.get(k);
                String current = old + letters[k / (ans.size() / lenOfNum)];
                ans.set(k, current);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }
}
