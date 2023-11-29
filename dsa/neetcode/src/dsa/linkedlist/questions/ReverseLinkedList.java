package dsa.linkedlist.questions;

/**
 * @author vkiprono
 * @created 11/28/23
 */

import dsa.linkedlist.ListNode;


/**
 * LEETCODE 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
    }

    /**
     * Time Complexity: O(N)
     *Space: O(1)
     *
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
