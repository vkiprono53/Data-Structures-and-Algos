package dsa.linkedlist.questions;

import dsa.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode 148. Sort List
 * <p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Example 1
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 */
public class SortList {
    public static void main(String[] args) {

    }

    /**
     * Solution 1 :
     * Time complexity - O(n log n)
     * Space complexity - O(n) - size of the list;
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode temp = head;
        List<Integer> myList = new ArrayList<>();
        while (temp != null) {
            myList.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(myList);
        ListNode head1 = new ListNode(myList.get(0));
        temp = head1;
        for (int i = 1; i < myList.size(); i++) {
            ListNode newNode = new ListNode(myList.get(i));
            temp.next = newNode;
            temp = temp.next;
        }
        return head1;

    }

    /**
     * Solution 2:
     * Time Complexity - O(n log n)
     * Space Complexity - O(n) --stack frame
     */
    public ListNode sortList1(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode temp = head;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }

        if (head1 != null)
            temp.next = head1;
        if (head2 != null)
            temp.next = head2;

        return head.next;
    }
}
