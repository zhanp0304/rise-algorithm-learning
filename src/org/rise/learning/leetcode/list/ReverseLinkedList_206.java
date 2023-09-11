package org.rise.learning.leetcode.list;

/**
 * <p>https://leetcode.cn/problems/reverse-linked-list/description/</p>
 * 206. 反转链表
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/11
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode ptr = head;
        while (ptr != null) {
            ListNode nextNode = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = nextNode;
        }
        return prev;
    }
}
