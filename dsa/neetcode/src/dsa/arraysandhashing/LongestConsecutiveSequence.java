package dsa.arraysandhashing;

import java.util.HashSet;
import java.util.Set;
/**
 * @author vkiprono
 * @created 3/11/24
 */

/**
 * LEETCODE 128. Longest Consecutive Sequence
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive
 * elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence consecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(consecutiveSequence.longestConsecutive1(nums));

    }

    /**
     * Brute Force
     */
    public int longestConsecutive(int[] nums) {

        int longestConsecutive = 0;

        for (int num : nums) {
            int currentElement = num;
            int currentLongest = 1;

            while (search(nums, currentElement + 1)) {
                currentElement++;
                currentLongest++;
            }
            longestConsecutive = Math.max(longestConsecutive, currentLongest);
        }

        return longestConsecutive;
    }

    public boolean search(int[] nums, int k) {
        for (int num : nums) {
            if (num == k) {
                return true;
            }
        }
        return false;
    }

    /**
     * Using Hashing
     */

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        int currentLongest = 1;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                currentLongest = 1;
                int currentElement = num;

                while (set.contains(currentElement + 1)){
                    currentLongest++;
                    currentElement++;
                }

            }
            longest = Math.max(currentLongest, longest);
        }
        return longest;
    }
}
