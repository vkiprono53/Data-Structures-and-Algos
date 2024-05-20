package dsa.binarysearch.questions;

/**
 * LEETCODE 367. Valid Perfect Square
 *
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 *
 * A perfect square is an integer that is the square of an integer.
 * In other words, it is the product of some integer with itself.
 *
 * You must not use any built-in library function, such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare1(14));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     *
     */
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int n = num / 2;
        if (num == 1 || num == 0) {
            return true;
        }

        while (start <= n) {
            if (start * start == num) {
                return true;
            }
            start++;
        }
        return false;
    }

    /**
     * Time Complexity -O(log n)
     * Space Complexity - O(1)
     */
    public boolean isPerfectSquare1(int num) {
        if (num == 1){
            return true;
        }
        double start = 1;
        double end = num / 2;
        double mid = 0;
        while (start <= end) {
            mid = Math.floor((end - start) / 2) + start;
            double midSquared = mid * mid;
            if (midSquared == num ){
                return true;
            }
            else if(midSquared < num){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}
