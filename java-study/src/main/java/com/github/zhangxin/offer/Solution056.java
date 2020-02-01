package com.github.zhangxin.offer;

import org.junit.Test;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/22 14:05
 * @Description:
 */
public class Solution056 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode meetingNode = getMeetingNode(pHead);
        if (meetingNode == null)
            return null;
        int numOfLoop = 1;
        ListNode node = meetingNode.next;
        while (node != meetingNode) {
            node = node.next;
            numOfLoop++;
        }
        ListNode fast = pHead;
        for (int i = numOfLoop; i > 0; i--) {
            fast = fast.next;
        }
        ListNode slow = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode getMeetingNode(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = slow.next;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return fast;
    }

    @Test
    public void test() {
        ListNode pHead = new ListNode(1);
        ListNode entry = EntryNodeOfLoop(pHead);
        System.out.println(entry);
    }
}
