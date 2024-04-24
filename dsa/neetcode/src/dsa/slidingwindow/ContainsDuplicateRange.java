package dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


/**
 * Given an integer array and a positive number `k`, check whether the array contains any duplicate
 * elements within the range `k`. If `k` is more than the array’s size, the solution should
 * check for duplicates in the complete array.
 * <p>
 * Input: nums[] = [5, 6, 8, 2, 4, 6, 9], k = 4
 * Output: true
 * Explanation: Element 6 repeats at distance 4 which is <= k
 * <p>
 * Input: nums[] = [5, 6, 8, 2, 4, 6, 9], k = 2
 * Output: false
 * Explanation: Element 6 repeats at distance 4 which is > k
 * <p>
 * Input: nums[] = [1, 2, 3, 2, 1], k = 7
 * Output: true
 * Explanation: Element 1 and 2 repeats at distance 4 and 2, respectively which are both <= k
 */
public class ContainsDuplicateRange {
    public static void main(String[] args) {
        ContainsDuplicateRange duplicateRange = new ContainsDuplicateRange();

        int[] nums = {5, 6, 8, 2, 4, 6, 9};
        int k = 4;
        System.out.println(duplicateRange.hasDuplicate2(nums, k));
    }

    /**
     *Time Complexity - O(n)
     * Space Complexity - O(k) - K is the window size
     */
    public boolean hasDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int left = 0; left < n; left++) {
            if (myMap.containsKey(nums[left])) {
                if (left - myMap.get(nums[left]) <= k) {
                    return true;
                }
            }
            myMap.put(nums[left], left);
        }
        return false;
    }

    public boolean hasDuplicate2(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return false;
        }
        Set<Integer> mySet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (mySet.contains(nums[i])) {
                return true;
            }
            mySet.add(nums[i]);
            if (mySet.size() > k) {
                mySet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
