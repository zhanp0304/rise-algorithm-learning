package org.rise.learning.leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * <p>142. 环形链表 II</p>
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/16
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode ptr = head;

        while (ptr != null) {
            ListNode node = map.get(ptr);
            if (node != null) {
                return node;
            }
            map.put(ptr, ptr);
            ptr = ptr.next;
        }

        return null;
    }
}
