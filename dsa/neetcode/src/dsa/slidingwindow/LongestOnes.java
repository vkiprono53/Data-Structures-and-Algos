package dsa.slidingwindow;

/**
 * LEETCODE 1004. Max Consecutive Ones III
 * <p>
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class LongestOnes {
    public static void main(String[] args) {
        LongestOnes longestOnes = new LongestOnes();
        int[] nums = {0, 0, 0, 1};
        int k = 4;
        System.out.println(longestOnes.longestOnes1(nums, k));

    }
    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     *
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0) { //  || if(k < 0)
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            maxLen = Math.max(maxLen, (right - left) + 1);

        }
        return maxLen;

    }

    /**
     * Time Complexity - O(n ^ 2)
     * Space Complexity - O(1)
     *
     */
    public int longestOnes1(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        int currentLen;
        int temp = 0;
        for (int l = 0; l < n; l++) {
            currentLen = 0;
            temp = k;
            for (int r = l; r < n; r++) {
                if (nums[r] == 0) {
                    temp--;
                }
                if (temp < 0) {
                    break;
                }
                currentLen = r - l + 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}
