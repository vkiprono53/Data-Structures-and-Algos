package dsa.slidingwindow;

/**
 * LEETCODE 1423. Maximum Points You Can Obtain from Cards
 * <p>
 * There are several cards arranged in a row, and each card has an associated number of points.
 * The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row.
 * You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1.
 * However, choosing the rightmost card first will maximize your total score.
 * The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * <p>
 * Example 2:
 * <p>
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 */
public class MaximumPoints {
    public static void main(String[] args) {
        MaximumPoints points = new MaximumPoints();
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(points.maxScore(cardPoints, k));
    }

    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null) {
            return 0;
        }
        int leftSum = 0;
        int rightSum = 0;
        int currentSum = 0;
        int n = cardPoints.length;
        int result = 0;

        if (k > n) {
            return 0;
        }
        //Left sum
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        result = leftSum;

        int m = n - 1;
        for (int j = k - 1; j >= 0; j--) {
            rightSum += cardPoints[m];
            leftSum -= cardPoints[j];
            currentSum = rightSum + leftSum;
            m--;
            result = Math.max(result, currentSum);
        }
        return result;
    }
}
