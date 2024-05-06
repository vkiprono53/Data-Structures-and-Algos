package dsa.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE 658. Find K Closest Elements
 * <p>
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 */
public class ClosestElements {
    public static void main(String[] args) {
        ClosestElements closestElements = new ClosestElements();
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        System.out.println(closestElements.findClosestElements(arr, k, x));

    }

    /**
     * Time Complexity - O(log n + k)
     * Space Complexity - O(k) - Number of elements in the list
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
