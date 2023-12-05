package dsa.linkedlist.questions;

/**
 * @author vkiprono
 * @created 11/28/23
 */

import dsa.linkedlist.ListNode;
import dsa.linkedlist.MyLinkedList;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * LEETCODE 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        ListNode head = linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("-----DISPLAY-------");
        linkedList.display(head);
        System.out.println("----REORDER-----");
        ListNode head1 = reverseList1(head);
        linkedList.display(head1);

    }

    /**
     * Time Complexity: O(N)
     *Space: O(1)
     *
     */
    public static ListNode reverseList(ListNode head) {
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

    /**
     *
     * Using Stack
     * Time - O(n)
     * Space - O(n)
     */
    public static ListNode reverseList1(ListNode head){
        Deque<Integer> myDeque = new ArrayDeque<>();
        ListNode temp = head;

        while (temp != null){
            myDeque.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (!myDeque.isEmpty()){
            temp.val = myDeque.peek();
            temp = temp.next;
            myDeque.pop();

        }
        return head;
    }

}
