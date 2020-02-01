package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/4 14:33
 * @Description: 链表的中间结点
 */
public class Solution0876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head, q = head;
        while (true) {
            q = q.next.next;
            p = p.next;
            if (q == null || q.next == null)
                return p;
        }
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 2, 2, 2, 2, 5, 5, 6));
        System.out.println(middleNode(head));
    }
}
