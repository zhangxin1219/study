package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 16:14
 * @Description: 重排链表
 */
public class Solution0143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 找到中间节点
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = fast == null ? slow : slow.next;
        }
        // 将slow与后面断开,从slow后一个开始反转
        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;
        ListNode p = null, q = slow;
        while (q != null) {
            q = q.next;
            slow.next = p;
            p = slow;
            slow = q;
        }
        // 拼接
        ListNode head1 = head, head2 = p, t1 = head1, t2 = head2;
        while (head2 != null) {
            t1 = head1.next;
            head1.next = head2;
            t2 = head2.next;
            head2.next = t1;
            head1 = t1;
            head2 = t2;
        }
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 2, 3, 4, 5,6));
        reorderList(head);
        System.out.println(head);
    }
}
