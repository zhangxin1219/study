package com.github.zhangxin.leetcode.linkedlist;

import com.github.zhangxin.leetcode.util.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: Zhang Xin
 * @Date: 2019/11/5 11:00
 * @Description: 对链表进行插入排序
 */
public class Solution0147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, current = head.next;// current为当前待插入至有序表[0,pre]元素
        while (current != null) {
            ListNode p = null, q = head;
            ListNode temp = current.next;// temp为下一轮待插入元素
            while (p != pre) {// 将current插入至有序表[0,pre]中
                if (p == null && current.val <= q.val) {// current<=第一个元素
                    pre.next = current.next;
                    current.next = q;
                    head = current;
                    break;
                }
                if (p != null && current.val > p.val && current.val <= q.val) {// current大于p并小于等于q
                    pre.next = current.next;
                    p.next = current;
                    current.next = q;
                    break;
                }
                if (current.val > pre.val && pre == q) {// current大于[0,pre]中所有元素
                    pre = current;
                    break;
                }
                p = q;
                q = q.next;
            }

            current = temp;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.convertList2ListNode(Arrays.asList(4, 19, 14, 5, -3, 1, 8, 5, 11, 15));
        ListNode ans = insertionSortList(head);
        System.out.println(ans);
    }
}
