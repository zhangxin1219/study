package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 16:00
 * @Description: 奇偶链表
 */
public class Solution0328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(0);// 奇数
        ListNode even = new ListNode(0);// 偶数
        ListNode oddHead = odd, evenHead = even;
        int currentIndex = 1;
        while (head != null) {
            if (currentIndex % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            currentIndex++;
        }
        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(2, 1, 3, 5, 6, 4, 7));
        ListNode ans = oddEvenList(head);
        System.out.println(ans);
    }
}
