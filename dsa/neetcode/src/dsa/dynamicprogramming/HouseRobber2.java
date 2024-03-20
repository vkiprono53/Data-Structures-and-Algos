package dsa.dynamicprogramming;

/**
 * @author vkiprono
 * @created 3/20/24
 */

/**
 * LEETCODE 213. House Robber II
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have a security system connected, and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {
    public static void main(String[] args) {

        HouseRobber2 robber2 = new HouseRobber2();
        int[] nums = {2, 3, 2};

        System.out.println(robber2.rob(nums));

    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2),
                robHelper(nums, 1, nums.length - 1));

    }

    public int robHelper(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;

        }

        return rob2;
    }
}
