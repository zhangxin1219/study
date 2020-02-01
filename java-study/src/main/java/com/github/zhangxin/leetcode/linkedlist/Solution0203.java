package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/4 15:16
 * @Description: 移除链表元素
 */
public class Solution0203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head.val == val) {
            head = head.next;
            if (head == null)
                return null;
        }
        ListNode p = head, q = head.next;
        while (q != null) {
            if (q.val == val)
                p.next = q.next;
            else
                p = q;
            q = q.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 1, 1, 2, 1, 1, 1));
        System.out.println(removeElements(head, 1));
    }
}
