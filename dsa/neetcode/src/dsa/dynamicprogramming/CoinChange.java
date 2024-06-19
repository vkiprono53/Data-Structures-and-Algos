package dsa.dynamicprogramming;

/**
 * @author vkiprono
 * @created 3/20/24
 */

/**
 * LEETCODE 322. Coin Change
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] nums = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange.coinChange(nums, amount));

    }

    /**
     * Space Complexity - O(n)
     * Time COmplexity = O(n * m) --n - amount, m - coin
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        //Fill the array with something invalid
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}