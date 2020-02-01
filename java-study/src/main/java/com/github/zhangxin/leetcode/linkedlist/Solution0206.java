package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/4 14:59
 * @Description: 反转链表
 */
public class Solution0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = null, q = head;
        while (q != null) {
            q = q.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 2, 3, 4));
        System.out.println(reverseList(head));

    }
}
