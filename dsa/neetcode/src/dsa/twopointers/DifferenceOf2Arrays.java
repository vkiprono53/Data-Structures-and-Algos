package dsa.twopointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LEETCODE 2215. Find the Difference of Two Arrays
 * <p>
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * <p>
 * Note that the integers in the lists may be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1
 * and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4
 * and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
 */
public class DifferenceOf2Arrays {
    public static void main(String[] args) {

        DifferenceOf2Arrays difference = new DifferenceOf2Arrays();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println(difference.findDifference(nums1, nums2));
    }

    /**
     *
     * Time Complexity - 0(n)
     * Space Complexity - O(n)
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (int num : nums1) {
            if (!set2.contains(num)) {
                if (!list1.contains(num)) {
                    list1.add(num);

                }

            }
        }
        for (int num : nums2) {
            if (!set1.contains(num)) {
                if (!list2.contains(num)) {
                    list2.add(num);

                }
            }
        }
        result.add(list1);
        result.add(list2);

        return result;

    }
}
