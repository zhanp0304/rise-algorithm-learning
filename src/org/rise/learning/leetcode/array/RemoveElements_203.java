package org.rise.learning.leetcode.array;

/**
 * <p>https://leetcode.cn/problems/remove-linked-list-elements/description/</p>
 * 203. 移除链表元素
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/9
 */
public class RemoveElements_203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val != val) {
                prev = cur;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
