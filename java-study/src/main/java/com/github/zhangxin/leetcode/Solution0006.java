package com.github.zhangxin.leetcode;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 13:04
 * @Description: Z字形变换
 */
public class Solution0006 {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || numRows == 0) {
            return s;
        }
        if (numRows >= len) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int k = 0; k < len; k++) {
            int row = 0;
            if (k % (2 * numRows - 2) >= 0 && k % (2 * numRows - 2) <= numRows - 1) {
                row = k % (2 * numRows - 2);
            } else {
                row = (2 * numRows - 2) - (k % (2 * numRows - 2));
            }
            if (null == sb[row]) {
                sb[row] = new StringBuilder();
            }
            sb[row].append(s.charAt(k));
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            temp.append(sb[i].toString());
        }
        return temp.toString();
    }

    @Test
    public void test() {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }
}
