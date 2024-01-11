package dsa.arraysandhashing;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * LEETCODE 217 : Contains Duplicate
 *
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

        int[] nums = {2,5,2,3,4};
        System.out.println(containsDuplicate(nums));

    }
    /**
     * Solution 1
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public static boolean containsDuplicate(int[] nums){
        Set<Integer> mySet = new HashSet<>();

        for (int num : nums){
            if (mySet.contains(num)){
                return true;
            }
            else{
                mySet.add(num);
            }
        }
        return false;
    }
}
