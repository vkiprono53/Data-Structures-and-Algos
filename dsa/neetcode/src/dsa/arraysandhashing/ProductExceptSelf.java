package dsa.arraysandhashing;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * LEETCODE 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all
 * the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf1(nums)));
    }

    /**
     * Time Complexity - O(n^2);
     * Space Complexity - O(1)
     */
    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++){
                if (i != j){
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;

    }

    /**
     * Time Complexity - O(n);
     * Space Complexity - O(n)
     */

    public static int[] productExceptSelf1(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        left[0] = 1;
        right[nums.length-1] = 1;

        //Left -> Right
        for(int i = 1 ; i < nums.length; i++){
            left[i] = nums[i- 1] * left[i-1];
        }

        //Right -> Left
        for (int i = nums.length-2 ; i >= 0; i--){
            right[i] = nums[i+1] * right[i+1];
        }

        for (int i = 0; i < nums.length; i++){
            result[i] = right[i] * left[i];
        }

        return result;
    }


    public int[] productExceptSelf2(int[] nums) {

        int leftProduct = 1;
        int rightProduct = 1;

        int[] result = new int[nums.length];

        //Left -> Right
        for(int i = 0 ; i < nums.length; i++){
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        //Right -> Left
        for (int i = nums.length-1 ; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

}
