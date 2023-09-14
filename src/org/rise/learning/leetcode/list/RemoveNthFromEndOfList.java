package org.rise.learning.leetcode.list;

/**
 * <p>https://leetcode.cn/problems/remove-nth-node-from-end-of-list/submissions/</p>
 * 19. 删除链表的倒数第 N 个结点
 * <p>链表中结点的数目为 sz</p>
 * <p>1 <= sz <= 30</p>
 * <p>0 <= Node.val <= 100</p>
 * <p>1 <= n <= sz</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/14
 */
public class RemoveNthFromEndOfList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // nodes.length <= 30
        ListNode[] nodes = new ListNode[30];
        int i = 0;
        int size = 0;
        ListNode ptr = head;

        while (ptr != null) {
            nodes[i++] = ptr;
            ptr = ptr.next;
            ++size;
        }

        int deleteIndex = size - n;

        if (n == size) {
            // delete the first one <=> head node
            return head.next;
        }

        nodes[deleteIndex - 1].next = nodes[deleteIndex].next;
        return head;
    }
}
