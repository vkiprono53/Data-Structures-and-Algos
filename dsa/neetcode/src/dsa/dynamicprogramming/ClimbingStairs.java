package dsa.dynamicprogramming;

/**
 * @author vkiprono
 * @created 3/18/24
 */

/***
 *
 * LEETCODE 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *

 Example 1:

 Input: n = 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps

 Example 2:

 Input: n = 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step


 */
public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n < 1) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
