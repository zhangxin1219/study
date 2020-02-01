package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 18:45
 * @Description: 两两交换链表中的节点
 */
public class Solution0024 {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        if (p == null) return null;
        ListNode q = p.next;
        if (q == null) return head;
        ListNode r = head;
        while (q != null) {
            if (r != head)
                r.next = q;
            else
                head = q;
            if (q.next != null) {
                p.next = q.next;
                q.next = p;
                r = p;
                p = p.next;
                q = p.next;
                if (q == null)
                    break;
            } else {
                p.next = null;
                q.next = p;
                break;
            }
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(swapPairs(head));
    }
}
