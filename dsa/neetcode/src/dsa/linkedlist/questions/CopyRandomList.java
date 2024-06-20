package dsa.linkedlist.questions;


/**
 * LeetCode 138. Copy List with Random Pointer
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such
 * that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 * <p>
 * Your code will only be given the head of the original linked list.
 */
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //Step 1 : Copying the nodes and interleaving them with the original nodes
        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        //Step 2 : Assigned random pointers for the new nodes
        Node temp1 = head;
        while (temp1 != null) {
            if (temp1.random != null) {
                temp1.next.random = temp1.random.next;
            }
            temp1 = temp1.next.next;
        }

        //Step 3: Restore original list and extract clone copies:
        Node copyHead = head.next;
        Node current = head;

        while (current != null) {
            Node clone = current.next;
            current.next = clone.next;

            clone.next = (clone.next != null) ? clone.next.next : null;
            current = current.next;
        }

        return copyHead;

    }

}
