package com.github.zhangxin.offer;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/2/3 18:17
 * @Description:
 */
public class Solution013 {
    public ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }
        if (toBeDeleted.next != null) {
            ListNode next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next.next;
        } else if (head == toBeDeleted) {
            head = null;
        } else {
            ListNode node = head;
            while (node.next != toBeDeleted && node.next != null) {
                node = node.next;
            }
            if (node.next == null) {
                return head;
            }
            node.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(0);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        Solution013 solution013 = new Solution013();
        listNode = solution013.deleteNode(listNode, listNode3);
        System.out.println(listNode);
    }
}
