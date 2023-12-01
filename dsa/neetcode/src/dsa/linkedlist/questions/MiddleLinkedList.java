package dsa.linkedlist.questions;

/**
 * @author vkiprono
 * @created 11/30/23
 */

import dsa.linkedlist.ListNode;
import dsa.linkedlist.MyLinkedList;

/**
 * LEETCODE 876. Middle of the Linked List
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        ListNode head = linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println("-----DISPLAY-------");
        System.out.print(middleNode(head).val);
    }

    /**
     *
     * Time - O(n)
     * Space - O(1)
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
