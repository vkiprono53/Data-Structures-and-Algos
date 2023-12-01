package dsa.linkedlist.questions;

/**
 * @author vkiprono
 * @created 11/30/23
 */

import dsa.linkedlist.ListNode;
import dsa.linkedlist.MyLinkedList;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LEETCODE 143. Reorder List
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {
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
        reorderList(head);
        linkedList.display(head);
    }

    public static void reorderList(ListNode head) {
        Deque<Integer>myDeque = new ArrayDeque<>();
        ListNode temp = head;

        while(temp != null){
            myDeque.addLast(temp.val);
            temp = temp.next;
        }

        int i = 0;
        temp = head;
        while(!myDeque.isEmpty()){
            if(i % 2 == 0){
                temp.val = myDeque.removeFirst();
            }
            else{
                temp.val = myDeque.removeLast();
            }
            i++;
            temp = temp.next;
        }

    }

    public void reorderList1(ListNode head) {
       ListNode mid = findMid(head);

    }
    //mid
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //Reverse the upper part:
    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
