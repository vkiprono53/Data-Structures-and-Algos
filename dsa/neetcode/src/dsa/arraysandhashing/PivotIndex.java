package dsa.arraysandhashing;

/**
 * LEETCODE 724. Find Pivot Index
 * Given an array of integers nums, calculate the pivot index of this array.
 * <p>
 * The pivot index is the index where the sum of all the numbers strictly to the left of
 * the index is equal to the sum of all the numbers strictly to the index's right.
 * <p>
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the array.
 * <p>
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class PivotIndex {
    public static void main(String[] args) {

        PivotIndex index = new PivotIndex();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(index.pivotIndex(nums));
    }

    /**
     *Space Complexity - O(1)
     * Time Complexity - O(n)
     */
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
            if (totalSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
