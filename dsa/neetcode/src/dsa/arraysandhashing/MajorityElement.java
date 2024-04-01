package dsa.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * LEETCODE 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public static void main(String[] args) {

        int[] nums = {3, 2, 3};
        MajorityElement element = new MajorityElement();
        System.out.println(element.majorityElement1(nums));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int majority = -1;
        if (n == 1) {
            return nums[0];
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > n / 2) {
                    majority = nums[i];
                    break;
                }

            } else {
                map.put(nums[i], 1);
            }
        }
        return majority;
    }

    /**
     * BRUTE FORCE
     * Space - O(1)
     * Time - O(n^2)
     */
    public int majorityElement1(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                    if (count > (nums.length / 2)) {
                        return num;
                    }
                }
            }
        }
        return -1;
    }

}
