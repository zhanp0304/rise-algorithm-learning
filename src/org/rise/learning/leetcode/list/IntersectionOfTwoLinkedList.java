package org.rise.learning.leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/description/</p>
 * 面试题 02.07. 链表相交
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/15
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, ListNode> nodeMap = new HashMap<>();

        ListNode ptrA  = headA;
        ListNode ptrB = headB;
        ListNode ptr;

        while (ptrA != null || ptrB != null) {

            if (ptrA == ptrB) {
                return ptrA;
            }

            if (ptrA != null) {
                ptr = nodeMap.get(ptrA);
                if (ptrA == ptr) {
                    return ptrA;
                }
                nodeMap.put(ptrA, ptrA);
                ptrA = ptrA.next;
            }

            if (ptrB != null) {
                ptr = nodeMap.get(ptrB);
                if (ptrB == ptr) {
                    return ptrB;
                }
                nodeMap.put(ptrB, ptrB);
                ptrB = ptrB.next;
            }
        }

        return null;
    }
}
