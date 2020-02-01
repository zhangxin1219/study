package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/12 14:11
 * @Description: 删除链表的倒数第N个节点
 */
public class Solution0009 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        int i = 1;
        while (i < n) {
            fast = fast.next;
            i++;
        }
        ListNode pre = null;
        while (true) {
            fast = fast.next;
            if (fast == null)
                break;
            pre = slow;
            slow = slow.next;
        }
        if (pre != null) {
            pre.next = slow.next;
            return head;
        } else {
            return head.next;
        }
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(removeNthFromEnd(head, 3));
    }

}
