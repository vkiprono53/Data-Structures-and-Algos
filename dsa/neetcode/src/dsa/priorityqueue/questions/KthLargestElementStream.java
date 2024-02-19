package dsa.priorityqueue.questions;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
/**
 * @author vkiprono
 * @created 2/19/24
 */

/**
 * LEETCODE 703. Kth Largest Element in a Stream
 * <p>
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Implement KthLargest class:
 * <p>
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 */
public class KthLargestElementStream {
    public static void main(String[] args) {

    }

/*    //Solution 1 :
    List<Integer> numsList = new ArrayList<>();
    int largestIndex;
    public KthLargestElementStream(int k, int[] nums) {
        largestIndex = k;
        for (int num : nums) {
            numsList.add(num);
        }

    }

    public int add(int val) {
        numsList.add(val);
        Collections.sort(numsList);
        return numsList.get(numsList.size() - largestIndex);
    }*/

    //Solution 2:

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;
    public KthLargestElementStream(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }


    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k){
            queue.poll();
        }
        return queue.peek();
    }

}
