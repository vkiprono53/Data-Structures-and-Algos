package dsa.binarysearch.questions;

import java.util.Arrays;

/**
 * LEETCODE 977. Squares of a Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
 * number sorted in non-decreasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares squares = new SortedSquares();
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squares.sortedSquares(nums)));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     *
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int k = n - 1;
        int[] result = new int[n];
        while (start <= end) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];
            if (startSquare > endSquare) {
                result[k] = startSquare;
                start++;
            } else {
                result[k] = endSquare;
                end--;
            }
            k--;
        }
        return result;
    }

    /**
     *Time Complexity - O(n log n)
     * Space Complexity - O(1)
     */
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
