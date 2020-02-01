package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/4 14:15
 * @Description: 删除排序链表中的重复元素
 */
public class Solution0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head, q = head.next;
        while (q != null) {
            if (p.val == q.val) {
                q = q.next;
                p.next = q;
            } else {
                p = q;
                q = q.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 1, 1, 1, 2, 2, 3));
        System.out.println(deleteDuplicates(head));
    }
}
