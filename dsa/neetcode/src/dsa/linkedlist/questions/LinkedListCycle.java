package dsa.linkedlist.questions;
import java.util.Set;
import java.util.HashSet;
/**
 * @author vkiprono
 * @created 11/29/23
 */

import dsa.linkedlist.ListNode;

/**
 * LEETCODE 141. Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer. Internally, pos is used to denote the
 * index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    /**
     * Solution 1 - Using HashSet
     * Time Complexity: O(N)
     *
     * Space Complexity: O(N)
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if (set.contains(head)){
                return true;
            }
            else{
                set.add(head);
            }
            head = head.next;
        }

        return false;
    }

    /**
     * Solution 2 - Using Fast and Slow pointers
     *
     * Time Complexity: O(N)
     *
     * Space Complexity: O(1)
     *
     */
    public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null){
            return false;
        }
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)){
                return true;
            }
        }
        return false;
    }
}
