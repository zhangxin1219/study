package com.github.zhangxin.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/7 11:34
 * @Description:
 */
public class Solution0051 {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = -1;
        }
        solveNQueens(n, a, 0);
        return ans;
    }

    public void solveNQueens(int n, int[] a, int k) {
        if (k == a.length) {
            List<String> res = new LinkedList<>();
            StringBuilder row = new StringBuilder("");
            for(int i=0;i<n;i++){
                row.append(".");
            }

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(row);
                sb.replace(a[i], a[i] + 1, "Q");
                res.add(sb.toString());
            }
            ans.add(new ArrayList(res));
            return;
        }
        for (int i = 0; i < n; i++) {
            a[k] = i;
            if (!isValid(a, k))
                continue;
            solveNQueens(n, a, k + 1);
            a[k] = -1;
        }
    }

    public boolean isValid(int[] a, int k) {
        if (k == 0)
            return true;
        for (int i = 0; i < k; i++) {
            if (a[i] == a[k] || Math.abs(a[k] - a[i]) == Math.abs(k - i))
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }
}
