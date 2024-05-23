package dsa.binarysearch.questions;

/**
 * LEETCODE 153. Find Minimum in Rotated Sorted Array
 * <p>
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * <p>
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 */
public class MinInSortedRotatedArray {
    public static void main(String[] args) {
        MinInSortedRotatedArray sortedRotatedArray = new MinInSortedRotatedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(sortedRotatedArray.findMin(nums));

    }

    /**
     * Brute Force ----- Linear search
     * Time Complecity - O(n)
     * Space Complexity - O(1)
     */
    public int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Time Complexity - O(log n)
     * Space Complexity - O(1)
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int n = nums.length;
        int end = n - 1;
        int start = 0;
        int mid = 0;

        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        while (start < end) {
            mid = start + (end - start) / 2;
            // if mid is less than the previous element
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (mid < n - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[start] <= nums[mid]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return -1;

    }

    /**
     * Time Complexity - O(log n)
     * Space Complexity - O(1)
     ***/
    public int findMin(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        int min = Integer.MAX_VALUE;

        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]) {
                min = Math.min(min, nums[start]);
                start = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }
        return min;
    }
}
