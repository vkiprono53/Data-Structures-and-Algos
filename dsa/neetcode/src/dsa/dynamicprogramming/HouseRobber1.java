package dsa.dynamicprogramming;

/**
 * @author vkiprono
 * @created 3/19/24
 */

/**
 * LEETCODE 198. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of
 * money you can rob tonight without alerting the police.
 */
public class HouseRobber1 {
    public static void main(String[] args) {

        HouseRobber1 robber1 = new HouseRobber1();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(robber1.rob(nums));
    }

    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[len];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[len - 1];
    }
}
