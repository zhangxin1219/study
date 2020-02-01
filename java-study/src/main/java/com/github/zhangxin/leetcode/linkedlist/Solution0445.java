package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 10:26
 * @Description: 两数相加
 */
public class Solution0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode ans = new ListNode(0), p = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            p.val = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry) % 10;
            carry = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            p.next = (l1 == null && l2 == null && carry == 0) ? null : new ListNode(0);
            p = p.next;
        }
        ans = reverseList(ans);
        return ans;
    }

    public ListNode reverseList(ListNode h) {
        if (h == null || h.next == null) return h;
        ListNode p = null;
        while (h != null) {
            ListNode q = h.next;
            h.next = p;
            p = h;
            h = q;
        }
        return p;
    }

    @Test
    public void test() {
        ListNode l1 = ListNode.convertList2ListNode(Arrays.asList(1, 2, 3, 4));
        ListNode l2 = ListNode.convertList2ListNode(Arrays.asList(9, 5, 6, 7, 8, 9, 9));
        System.out.println(addTwoNumbers(l1, l2));
    }

}
