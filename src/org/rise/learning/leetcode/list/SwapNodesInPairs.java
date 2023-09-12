package org.rise.learning.leetcode.list;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/submissions/
 * <p>24. 两两交换链表中的节点</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/12
 */
public class SwapNodesInPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            // return swapSimulation(head);
            return swapRecursion(head);
        }

        public ListNode swapRecursion(ListNode head) {
            if (head == null || head.next == null) {
                // 至少有三者，才需要交换元素
                return head;
            }

            // 这是每一轮都要做的重复操作
            ListNode t1 = head.next;
            ListNode t2 = head.next.next;
            t1.next = head;

            // 每一轮要连接的是下一轮函数返回的头节点
            head.next = swapRecursion(t2);

            // 对于每次递归来说，要返回的是头节点
            return t1;

        }


        public ListNode swapSimulation(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode newHead = head;
            if (head.next != null) {
                newHead = head.next;
            }

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode p0 = dummy;
            ListNode p1 = head;
            ListNode p2 = head.next;

            while (p0 != null && p1 != null && p2 != null) {
                p1.next = p2.next;
                p2.next = p1;
                p0.next = p2;

                p0 = p1;
                p1 = p1 == null ? null : p1.next;
                p2 = p1 == null ? null : p1.next;
            }

            return newHead;
        }
    }
}
