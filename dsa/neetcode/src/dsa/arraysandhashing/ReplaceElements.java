package dsa.arraysandhashing;

import java.util.Arrays;

/**
 * 1299. Replace Elements with Greatest Element on Right Side
 * <p>
 * Given an array arr, replace every element in that array with the greatest element among the
 * elements to its right, and replace the last element with -1.
 * <p>
 * After doing so, return the array.
 * <p>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 */
public class ReplaceElements {
    public static void main(String[] args) {
        ReplaceElements element = new ReplaceElements();
        int[] nums = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(element.replaceElements2(nums)));
    }

    /**
     * Space Complexity - O(n^2)
     * Time Complexity - O(1)
     */
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int largest = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > largest) {
                    largest = arr[j];
                }
            }
            arr[i] = largest;
        }
        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1];
        arr[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max) {
                max = temp;
            }
        }
        return arr;
    }
}