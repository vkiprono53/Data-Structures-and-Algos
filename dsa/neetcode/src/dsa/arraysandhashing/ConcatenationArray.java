package dsa.arraysandhashing;

import java.util.Arrays;

/**
 * LEETCODE 1929. Concatenation of Array
 * Given an integer array nums of length n, you want to create an array ans of length 2n where
 * ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 *
 * Specifically, ans is the concatenation of two nums arrays.
 *
 * Return the array ans.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [1,2,1,1,2,1]
 * Explanation: The array ans is formed as follows:
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 */
public class ConcatenationArray {
    public static void main(String[] args) {
        ConcatenationArray array = new ConcatenationArray();
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(array.getConcatenation(nums)));
    }

    /**
     *
     * Space complexity - O(1)
     * Time complexity - O(n)
     */
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int n = nums.length;
        for (int i = 0; i < ans.length; i++){
            if (i < nums.length){
                ans[i] = nums[i];
            }
            else{
                ans[i] = nums[i - n];
            }
        }
        return ans;
    }
}
