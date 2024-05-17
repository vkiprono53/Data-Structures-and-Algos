package dsa.binarysearch.questions;

/**
 * LEETCODE 441. Arranging Coins
 * <p>
 * You have n coins and you want to build a staircase with these coins.
 * The staircase consists of k rows where the ith row has exactly i coins.
 * The last row of the staircase may be incomplete.
 * <p>
 * Given the integer n, return the number of complete rows of the staircase you will build.
 * <p>
 * Example 1
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 */
public class ArrangingCoins {
    public static void main(String[] args) {

    }

    /**
     * Iterative solution:
     * Time complexity -  O(sqrt(n))
     * Space complexity - O(1)
     */
    public int arrangeCoins1(int n) {
        int row = 1;
        while (n > 0) {
            row++;
            n -= row;
        }
        return row - 1;
    }

    /**
     * Binary Search:
     * Space Complexity - O(1)
     * Time Complexity - O(log n)
     */
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        long mid = 0;
        long coinsUsed = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            coinsUsed = mid * (mid + 1) / 2;

            if (coinsUsed == n) {
                return (int) mid;
            } else if (n < coinsUsed) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return (int) end;

    }
}
