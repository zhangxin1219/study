package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 16:11
 * @Description: 环形链表Ⅱ
 */
public class Solution0142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {// 没有环
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 第一次相遇
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(5, 3, 2, 7, 1, 6, 8, 9, 4), 4);
        ListNode start = detectCycle(head);
        System.out.println(start.indexOf(head));
    }
}
