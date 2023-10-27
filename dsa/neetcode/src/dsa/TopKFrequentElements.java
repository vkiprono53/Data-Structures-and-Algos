package dsa;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LEETCODE 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequentElements {
    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        int  k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    /**
     * Time Complexity: O(n log(k)), where n is the number of elements in nums.
     * Space Complexity: O(n + k), for the counts hash map with n elements and the heap of size k
     *
     */
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        PriorityQueue<Map.Entry<Integer, Integer>> myQueue =
                new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //add map to the queue
        myQueue.addAll(map.entrySet());

       for (int i = 0; i <k ; i++){
           result[i] = myQueue.poll().getKey();
       }

        return result;
    }
}
