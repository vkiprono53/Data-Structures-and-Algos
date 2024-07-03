package dsa.linkedlist.questions;

import dsa.linkedlist.ListNode;

/**
 * Leetcode 445. Add Two Numbers II
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 */
public class AddTwoNumbers2 {
    public static void main(String[] args) {

    }

    /**
     * Time Complexity - O(n)
     * Space Complexity -
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverseList(l1);
        ListNode reverseL2 = reverseList(l2);

        int sum = 0;
        int carryOne = 0;
        int lastDigit = 0;
        ListNode head = new ListNode();
        ListNode temp = head;

        while (reverseL1 != null || reverseL2 != null) {
            int val1 = (reverseL1 != null) ? reverseL1.val : 0;
            int val2 = (reverseL2 != null) ? reverseL2.val : 0;
            sum = val1 + val2 + carryOne;
            lastDigit = sum % 10;
            carryOne = sum / 10;
            temp.next = new ListNode(lastDigit);
            if (reverseL1 != null) {
                reverseL1 = reverseL1.next;
            }
            if (reverseL2 != null) {
                reverseL2 = reverseL2.next;
            }
            temp = temp.next;
        }
        if (carryOne == 1) {
            temp.next = new ListNode(1);
        }

        return reverseList(head.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
