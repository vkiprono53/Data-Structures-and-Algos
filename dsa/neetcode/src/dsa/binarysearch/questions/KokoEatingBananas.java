package dsa.binarysearch.questions;

import java.util.Arrays;
import java.util.Collections;

/**
 * LEETCODE 875. Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas
 * and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them
 * instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(kokoEatingBananas.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed1(int[] piles, int h) {
        double k = 1;
        int result = 0;
        long i = 1;
        Arrays.sort(piles);
        long largest = piles[piles.length - 1];
        while (i <= largest) {
            for (int pile : piles) {
                k = (double) pile / i;
                result += Math.ceil(k);

            }
            if (result == h) {
                return (int) i;
            } else {
                i++;
                k = 0;
                result = 0;
            }
        }
        return result;
    }

    /**
     *
     * Time Complexity - O(n + log(max(piles));
     * Space Complexity - O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = findMax(piles);
        if (h == max) {
            return max;
        }
        int start = 1;
        int end = max;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            int totalHours = 0;

            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }
            if (totalHours <= h) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;

    }
    private int findMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }

}
