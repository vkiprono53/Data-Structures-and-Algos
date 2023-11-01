package dsa.arraysandhashing;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
/**
 *LEETCODE 1 : TWO SUM
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {

      int[] nums = {2,7,11,15};
      int  target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     *
     *
     * Solution 1 : using the HashMap
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int complement = 0;
        for (int i = 0; i < nums.length; i++){
            complement = target - nums[i];
            if (map.containsKey(complement)){
                result[0] = i;
                result[1] = map.get(complement);
                return result;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

}
