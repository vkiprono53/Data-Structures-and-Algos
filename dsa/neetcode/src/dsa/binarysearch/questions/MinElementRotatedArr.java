package dsa.binarysearch.questions;

/**
 * @author vkiprono
 * @created 11/24/23
 */

public class MinElementRotatedArr {
    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMinLinear(nums));
        System.out.println(findMin(nums));
    }

    /**
     *
     * Using Linear search
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public static int findMinLinear(int[] nums) {
        int min = nums[0];

        for(int num : nums){
            if (num < min){
                min = num;
            }
        }
        return min;
    }
    /**
     * Using Binary Search
     * Time Complexity - O(log n)
     * Space Complexity - O(1)
     */
    public static int findMin(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        if (nums[low] < nums[high]){
            return nums[low];
        }

        while (low < high){
            mid = (high + low) / 2;

            if (nums[high] >= nums[mid]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
