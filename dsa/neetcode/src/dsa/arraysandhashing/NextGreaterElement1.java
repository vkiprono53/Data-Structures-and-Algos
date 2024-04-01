package dsa.arraysandhashing;

import java.util.*;

/**
 * LEETCODE 496. Next Greater Element I
 * The next greater element of some element x in an array is the first greater element that
 * is to the right of x in the same array.
 * <p>
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is
 * a subset of nums2.
 * <p>
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
 * and determine the next greater element of nums2[j] in nums2. If there is no next greater element,
 * then the answer for this query is -1.
 * <p>
 * Return an array ans of length nums1.length such that ans[i] is the next greater
 * element as described above.
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 */
public class NextGreaterElement1 {
    public static void main(String[] args) {

        NextGreaterElement1 element1 = new NextGreaterElement1();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(element1.nextGreaterElement(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.add(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[1], -1);
        }

        return nums1;
    }
}
