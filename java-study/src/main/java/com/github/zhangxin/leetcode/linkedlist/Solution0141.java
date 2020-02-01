package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/2 14:53
 * @Description: 环形链表
 */
public class Solution0141 {
    public boolean hasCycle1(ListNode head) {// 哈希表法
        ListNode temp = head;
        Map<ListNode, Integer> hashMap = new HashMap<>();
        while (temp != null) {
            if (!hashMap.containsKey(temp)) {// 哈希表中没有,表示没有遍历过
                hashMap.put(temp, temp.val);
            } else {
                long end1 = System.currentTimeMillis();
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {// 快慢指针法,如果有环快指针一定能追上慢指针
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(3, 2, 0, -4), 1);
        System.out.println(hasCycle1(head));
        System.out.println(hasCycle2(head));
    }
}
