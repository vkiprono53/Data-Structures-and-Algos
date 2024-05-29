package dsa.linkedlist.questions;

import dsa.linkedlist.ListNode;

/**
 * Leetcode 2. Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode();
        ListNode temp = headNode;
        int carryOne = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int currentSum = val1 + val2 + carryOne;
            carryOne = currentSum / 10;
            int lastDigit = currentSum % 10;

            temp.next = new ListNode(lastDigit);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        // check if 1 is left
        if (carryOne == 1) {
            temp.next = new ListNode(carryOne);
        }
        return headNode.next;
    }
}
