package dsa.twopointers;

import java.util.Arrays;

/**
 * LEETCODE 1984. Minimum Difference Between Highest and Lowest of K Scores
 * <p>
 * You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student.
 * You are also given an integer k.
 * <p>
 * Pick the scores of any k students from the array so that the difference between the highest and the
 * lowest of the k scores is minimized.
 * <p>
 * Return the minimum possible difference.
 * <p>
 * Input: nums = [9,4,1,7], k = 2
 * Output: 2
 */
public class MinimumDifference {
    public static void main(String[] args) {

        MinimumDifference difference = new MinimumDifference();
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        System.out.println(difference.minimumDifference(nums, k));
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[k - 1] - nums[0];

        for (int i = k; i < nums.length; i++) {
            ans = Math.min(ans, (nums[i] - nums[i - k + 1]));
        }
        return ans;
    }
}
