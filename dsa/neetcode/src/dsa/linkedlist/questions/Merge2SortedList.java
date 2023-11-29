package dsa.linkedlist.questions;

/**
 * @author vkiprono
 * @created 11/29/23
 */

import dsa.linkedlist.ListNode;

/**
 * LEETCODE 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 */
public class Merge2SortedList {
    public static void main(String[] args) {


    }

    /**
     * Time complexity is O(m + n) - m = Length of the first list, n = Length of the second list
     * Space complexity - O(1)
     *
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode temp = new ListNode();
        ListNode head = temp;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
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
