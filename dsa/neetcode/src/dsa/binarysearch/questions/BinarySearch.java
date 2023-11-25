package dsa.binarysearch.questions;

/**
 * @author vkiprono
 * @created 11/23/23
 */

import java.util.Arrays;

/**
 *
 * LEETCODE 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int  target = 9;
        System.out.println(search(nums, target));
        //Using inbuilt:
        System.out.println(Arrays.binarySearch(nums, target));

    }
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;

        while(low <= high){
            mid = (high + low) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
