package dsa.linkedlist;

import java.util.LinkedList;

/**
 * @author vkiprono
 * @created 11/27/23
 */

public class LinkedListInbuilt {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        //Add
        linkedList.add("Vivaldi");
        linkedList.add("Fach");
        linkedList.add("Lyn");
        linkedList.add("Java");
        //Print
        System.out.println(linkedList);
        //Add to specifi location
        linkedList.add(1, "Mozart");
        System.out.println(linkedList);
        //add first
        linkedList.addFirst("Yea");
        //add last
        linkedList.addLast("Code");
        System.out.println(linkedList);
        //remove
        linkedList.remove();
        System.out.println(linkedList);
        //update
        linkedList.set(0, "Classics");
        System.out.println(linkedList);
        //iterating
        for(String name : linkedList){
            System.out.print(name +" -> ");
        }



    }
}
