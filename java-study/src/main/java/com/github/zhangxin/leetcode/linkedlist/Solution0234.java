package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 09:52
 * @Description: 回文链表
 */
public class Solution0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // 找到中间结点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 翻转前半部分
        ListNode p = null, q = null;
        while (head != slow) {
            q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        // 如果长度为技术,去掉后半部分第一个
        if (fast != null) {
            slow = slow.next;
        }
        // 判断
        while (slow != null) {
            if (slow.val != p.val)
                return false;
            slow = slow.next;
            p = p.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(1, 2, 3, 4, 5, 3, 2, 1));
        System.out.println(isPalindrome(head));
    }
}
