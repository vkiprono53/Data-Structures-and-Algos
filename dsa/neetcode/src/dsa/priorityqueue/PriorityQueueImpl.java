package dsa.priorityqueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
/**
 * @author vkiprono
 * @created 2/19/24
 */

public class PriorityQueueImpl {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> sortedList = new ArrayList<>();
        queue.addAll(Arrays.asList(4, 7, 3, 8, 2, 9, 6, 5, 1));
        System.out.println(queue);
        System.out.println("Peek: " + queue.peek());
        while (!queue.isEmpty()){
            int temp = queue.poll();
            sortedList.add(temp);
        }
        System.out.println(queue);
        System.out.println("---------SORTED LIST----------");
        System.out.println(sortedList);
    }

}
