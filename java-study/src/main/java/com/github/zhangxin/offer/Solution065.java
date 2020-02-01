package com.github.zhangxin.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/23 17:28
 * @Description:
 */
public class Solution065 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || size > num.length || size < 1)
            return ans;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (deque.size() > 0 && num[i] > num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans.add(num[deque.peekFirst()]);
        for (int i = size; i < num.length; i++) {
            while (deque.size() > 0 && num[i] > num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.size() > 0 && deque.peekFirst() <= i - size) {
                deque.pollFirst();
            }
            ans.add(num[deque.peekFirst()]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {2, 3, 4, 2, 6, 2, 5, 1};
        Solution065 solution065 = new Solution065();
        System.out.println(solution065.maxInWindows(x, 3));
    }
}
