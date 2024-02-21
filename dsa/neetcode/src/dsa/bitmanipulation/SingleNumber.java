package dsa.bitmanipulation;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author vkiprono
 * @created 2/21/24
 */

/**
 * LEETCODE 136. Single Number
 * <p>
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {

        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber2(nums));
    }

    /**
     * Using hashmap
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     *
     */
    public int singleNumber(int[] nums) {
        int result = -1;
        if (nums.length <= 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Entry<Integer, Integer> map1 : map.entrySet()) {
            if (map1.getValue() == 1) {
                result = map1.getKey();
                break;
            }
        }
        return result;
    }

    /**
     * XOR
     * Space Complexity - O(1)
     * Time Complexity - O(n)
     */
    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int num : nums){
            result = num ^ result;
        }
        return result;
    }

    /**
     * Using HashSet
     *
     */
    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }
        for (int num : set){
            return num;
        }
        return -1;
    }
}