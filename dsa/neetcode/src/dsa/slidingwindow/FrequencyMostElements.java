package dsa.slidingwindow;

import java.util.Arrays;

/**
 * LEETCODE 1838. Frequency of the Most Frequent Element
 * <p>
 * The frequency of an element is the number of times it occurs in an array.
 * <p>
 * You are given an integer array nums and an integer k. In one operation,
 * you can choose an index of nums and increment the element at that index by 1.
 * <p>
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 */
public class FrequencyMostElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int k = 5;
        FrequencyMostElements frequencyMostElements = new FrequencyMostElements();
        System.out.println(frequencyMostElements.maxFrequency(nums, k));
    }

    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int right = 1;
        long window = 0;
        int result = 1;
        Arrays.sort(nums);

        while (right < nums.length) {
            window += (long) (nums[right] - nums[right - 1]) * (right - left);

            while (window > k) {
                window -= nums[right] - nums[left];
                left++;
            }
            right++;
            result = Math.max(result, right - left);
        }
        return result;
    }
}
