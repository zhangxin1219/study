package com.github.zhangxin.offer;

/**
 * @Auther: Zhang Xin
 * @Date: 2020/1/22 14:06
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        if (this == null)
            return b.append("]").toString();
        ListNode temp;
        temp = this;
        int i = 0;
        while (true) {
            b.append(temp.val);
            if (temp.next == null || i > 15) {
                return b.append("]").toString();
            } else {
                b.append(",");
                temp = temp.next;
            }
            i++;
        }
    }
}
