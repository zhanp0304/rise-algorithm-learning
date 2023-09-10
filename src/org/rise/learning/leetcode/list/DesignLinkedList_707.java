package org.rise.learning.leetcode.list;

/**
 * <p>https://leetcode.cn/problems/design-linked-list/submissions/</p>
 * 707. 设计链表
 *
 * @author zhanpeng.jiang@hand-china.com 2023/9/10
 */
public class DesignLinkedList_707 {

    public static void main(String[] args) {
        // final result: 7,3, 2
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtIndex(1, 3);
        System.out.println(myLinkedList);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    ListNode dummy;
    ListNode tail;

    public MyLinkedList() {
        dummy = new ListNode();
        tail = null;
    }

    public int get(int index) {
        ListNode ptr = dummy.next;
        int cur = 0;
        while (ptr != null) {
            if (cur == index) {
                return ptr.val;
            }
            ++cur;
            ptr = ptr.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode oldHead = dummy.next;
        ListNode newHead = new ListNode(val, oldHead, dummy);
        dummy.next = newHead;

        if (oldHead == null) {
            tail = newHead;
        } else {
            oldHead.prev = newHead;
        }

    }

    public void addAtTail(int val) {
        if (tail == null) {
            addAtHead(val);
        } else {
            tail.next = new ListNode(val, null, tail);
            tail = tail.next;
        }
    }

    public void addAtIndex(int index, int val) {
        ListNode ptr = dummy;
        int cur = 0;
        while (ptr != null) {
            if (cur == index) {

                ListNode originalNextNode = ptr.next;
                ptr.next = new ListNode(val, originalNextNode, ptr);
                if (originalNextNode != null) {
                    originalNextNode.prev = ptr.next;
                }

                if (ptr == tail) {
                    tail = ptr.next;
                }
                return;
            }
            ++cur;
            ptr = ptr.next;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode ptr = dummy.next;
        int cur = 0;
        while (ptr != null) {
            if (cur == index) {
                ListNode nextNode = ptr.next;
                ListNode prevNode = ptr.prev;
                // free it
                ptr.next = null;

                // both side need to update
                prevNode.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                if (ptr == tail) {
                    tail = prevNode;
                }
                // free it
                ptr = null;
                return;
            }
            ++cur;
            ptr = ptr.next;
        }
    }
}
