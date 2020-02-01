package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 13:43
 * @Description: 反转链表Ⅱ
 */
public class Solution0092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (!(m >= 1 && n >= m) || m == n) return head;
        if (head == null || head.next == null) return head;
        ListNode p = null, q = head;
        int currentIndex = 0;
        while (currentIndex < m - 1) {
            p = q;
            q = q.next;
            currentIndex++;
        }
        ListNode pre = p;// pre为待反转区间前一个元素
        ListNode begin = pre == null ? head : pre.next;//begin反转区间的第一个
        p = null;
        q = begin;
        ListNode temp = begin;
        while (currentIndex < n) {
            q = q.next;
            temp.next = p;
            p = temp;
            temp = q;
            currentIndex++;
        }
        if (q != null)
            begin.next = q;
        if (m > 1)
            pre.next = p;
        else
            head = p;
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(3, 5));
        ListNode ans = reverseBetween(head, 1, 2);
        System.out.println(ans);
    }
}
