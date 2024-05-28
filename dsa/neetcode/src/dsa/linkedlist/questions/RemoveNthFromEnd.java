package dsa.linkedlist.questions;

import dsa.linkedlist.ListNode;

/**
 * Leetcode 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }
    /**
     * Time Complexity - O(len) + O(len - n);
     * Space Complexity - O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        temp = head;
        if (size == n) {
            return head.next;
        }
        int i = 1;
        while (i < size - n) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
    }
    /**
     * Time Complexity - O(len)
     * Space Complexity - O(1)
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
