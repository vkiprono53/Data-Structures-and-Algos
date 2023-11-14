package dsa.slidingwindow;

/**
 * @author vkiprono
 * @created 11/14/23
 */

/**
 * LEETCODE 121. Best Time to Buy and Sell Stock
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
 * return 0.
 */
public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

    }

    /**
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        int interimProfit = 0;

        for (int price : prices) {
            if (price < minValue) {
                minValue = price;
            }
            interimProfit = price - minValue;
            if (interimProfit > maxProfit) {
                maxProfit = interimProfit;
            }
        }

        return maxProfit;
    }
}
