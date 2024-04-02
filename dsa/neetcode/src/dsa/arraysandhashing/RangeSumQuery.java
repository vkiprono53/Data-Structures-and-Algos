package dsa.arraysandhashing;

/**
 * LEETCODE 303. Range Sum Query - Immutable
 * <p>
 * Given an integer array nums, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * <p>
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between
 * indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQuery {
    int[] sumArray;

    public static void main(String[] args) {

    }

    /**
     *Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public RangeSumQuery(int[] nums) {
        sumArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            sumArray[i] = nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int totalSum = 0;
        for (int i = left; i <= right; i++) {
            totalSum += sumArray[i];
        }
        return totalSum;
    }
}
