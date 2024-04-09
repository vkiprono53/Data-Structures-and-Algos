package dsa.slidingwindow;
import java.util.HashSet;
import java.util.Set;
/**
 * 219. Contains Duplicate II
 * <p>
 * Given an integer array nums and an integer k, return true if there are
 * two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 */
public class ContainsDuplicate2 {
    public static void main(String[] args) {
        ContainsDuplicate2 duplicate2 = new ContainsDuplicate2();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(duplicate2.containsNearbyDuplicate(nums, k));
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> mySet = new HashSet<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i - j) > k) {
                mySet.remove(nums[j]);
                j++;
            }
            if (mySet.contains(nums[i])) {
                return true;
            }
            mySet.add(nums[i]);
        }

        return false;
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
