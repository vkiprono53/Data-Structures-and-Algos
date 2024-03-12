package dsa.twopointers;

/**
 * @author vkiprono
 * @created 2/15/24
 */

import java.util.Arrays;

/**
 * LEETCODE 167. Two Sum II - Input Array Is Sorted
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
 * and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum1(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    if (i < j) {
                        result[0] = i + 1;
                        result[1] = j + 1;
                    } else {
                        result[0] = j + 1;
                        result[1] = i + 1;

                    }

                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        int first = 0;
        int last = numbers.length - 1;

        while (first < last){
            if (numbers[first] + numbers[last] == target){
                result[0] = first + 1;
                result[1] = last + 1;
                break;
            }
            else if (numbers[first] + numbers[last] < target){
                first++;
            }
            else {
                last--;
            }
        }

        return result;
    }
}
