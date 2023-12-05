package dsa.linkedlist;

/**
 * @author vkiprono
 * @created 11/28/23
 */

public class MyLinkedList {
    ListNode head;
    int size;



    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(8);
        System.out.println(linkedList.display(linkedList.head));
        System.out.println("Adding in front");
        ListNode head1 = linkedList.addFront(10);
        System.out.println(linkedList.display(head1));
        System.out.println("-----DELETING-----");
       // linkedList.delete(8);
        System.out.println(linkedList.display(linkedList.head));

    }

    //Add at the end:
    public ListNode add(int data){
        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        if (temp == null){
            head = newNode;
            return head;
        }
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
        return head;

    }
    public ListNode display(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println();
        return head;
    }

    //Add at the front
    public ListNode addFront(int data){
        ListNode newNode = new ListNode(data);

        if (head == null){
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    //Add at the specific position:
    public ListNode add(int data, int pos){
        int count = 1;
        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        if (temp == null){
            head = newNode;
            return head;
        }
        while (temp.next != null){
            temp = temp.next;
            if (count == pos){
                break;
            }
            count++;
        }
        newNode.next = temp.next.next;
        temp.next = newNode;
        if (pos > count){
            return head;
        }
        temp.next = newNode;
        size++;
        return head;

    }

    //Delete node-data
    public ListNode delete(int data){
        ListNode temp = head;
        if (temp == null){
            return head;
        }
        if (temp.val == data){
            head = temp.next;
        }

        while (temp != null){
            if (temp.next.val == data){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public int size(){
        return size;
    }
}
