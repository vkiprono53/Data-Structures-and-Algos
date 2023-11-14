package dsa.twopointers;

/**
 * @author vkiprono
 * @created 11/14/23
 */

/**
 * LEETCODE 11. Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such
 * that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container
 * contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int[] nums1 = {1,1};
        System.out.println(maxArea(nums));
        System.out.println(maxArea(nums1));

    }

    /**
     * Solution 1: Two pointer approach:
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     *
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int low = 0;
        int high = height.length - 1;

        while (low < high){
            if (height[low] < height[high]){
                maxArea = Math.max(maxArea, height[low] * (high-low));
                low++;
            }
            else {
                maxArea = Math.max(maxArea, height[high] * (high-low));
                high--;
            }
        }

        return maxArea;
    }



}
