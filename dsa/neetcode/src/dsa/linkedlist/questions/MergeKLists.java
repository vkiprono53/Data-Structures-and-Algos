package dsa.linkedlist.questions;

import dsa.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * Leetcode 23. Merge k Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    public static void main(String[] args) {

    }

    /**
     * Time Complexity - O(n log (k))
     * Space Complexity - O(k)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode listNode : lists) {
            if (listNode != null) {
                minHeap.add(listNode);
            }
        }

        ListNode head = new ListNode();
        ListNode temp = head;

        while (!minHeap.isEmpty()) {
            ListNode nodeRemove = minHeap.remove();
            temp.next = nodeRemove;
            temp = temp.next;
            if (nodeRemove.next != null) {
                minHeap.add(nodeRemove.next);
            }
        }
        return head.next;

    }

    /**
     * Time Complexity - O(k *n )
     * Space Complexity - O(1)
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode head = new ListNode();

        for (ListNode listNode : lists) {
            head.next = merge(head.next, listNode);
        }
        return head.next;

    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return head.next;
    }
}
