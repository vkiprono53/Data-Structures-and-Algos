package dsa.arraysandhashing;

/**
 * LEETCODE 413. Arithmetic Slices
 * <p>
 * An integer array is called arithmetic if it consists of at least three elements and if the
 * difference between any two consecutive elements is the same.
 * <p>
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * <p>
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        ArithmeticSlices slices = new ArithmeticSlices();
        int[] nums = {1, 2, 3, 4};
        System.out.println(slices.numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            while (i + 2 < n && (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i])) {
                count++;
                totalCount += count;
                i++;
            }
        }
        return totalCount;
    }
}
