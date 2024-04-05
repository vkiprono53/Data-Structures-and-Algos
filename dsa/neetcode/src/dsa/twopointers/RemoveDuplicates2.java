package dsa.twopointers;

/**
 * LEETCODE 80. Remove Duplicates from Sorted Array II
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
 * such that each unique element appears at most twice. The relative order of the elements should be
 * kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead
 * have the result be placed in the first part of the array nums. More formally, if there are k elements
 * after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place
 * with O(1) extra memory.
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        RemoveDuplicates2 duplicates2 = new RemoveDuplicates2();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(duplicates2.removeDuplicates(nums));

    }

    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
