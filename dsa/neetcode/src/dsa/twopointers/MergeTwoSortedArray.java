package dsa.twopointers;

/**
 * Leetcode 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside
 * the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        MergeTwoSortedArray sortedArray = new MergeTwoSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int n = 3;
        int[] nums2 = {2, 5, 6};
        sortedArray.merge(nums1, m, nums2, n);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        int first = 0;
        int second = 0;
        int[] result = new int[m + n];

        while (first < m && second < n) {
            if (nums1[first] <= nums2[second]) {
            //    nums1[k] = nums1[first];
                result[k] = nums1[first];
                first++;
            }
            else {
             //   nums1[k] = nums2[second];
                result[k] = nums2[second];
                second++;
            }
            k++;
        }

        while (first < m) {
            result[k] = nums1[first];
            first++;
            k++;
        }
        while (second < n) {
            result[k] = nums2[second];
            second++;
            k++;
        }
        for (int i = 0 ; i < result.length; i++){
            nums1[i] = result[i];
        }
    }
}
