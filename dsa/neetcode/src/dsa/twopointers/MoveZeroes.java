package dsa.twopointers;

/**
 * LEETCODE 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative
 * order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes zeroes = new MoveZeroes();
        zeroes.moveZeroes(nums);
    }

    /**
     *
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i< nums.length; i++){
            nums[i] = 0;
        }
    }
}
