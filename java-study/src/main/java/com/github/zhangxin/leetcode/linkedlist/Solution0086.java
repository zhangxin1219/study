package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 13:05
 * @Description: 分隔链表
 */
public class Solution0086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode less = new ListNode(0), lessHead = less;
        ListNode more = new ListNode(0), moreHead = more;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                more.next = current;
                more = more.next;
            }
            current = current.next;
        }
        less.next = moreHead.next;
        more.next = null;
        return lessHead.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 4, 3, 2, 5, 2));
        ListNode ans = partition(head, 3);
        System.out.println(ans);
    }

}
