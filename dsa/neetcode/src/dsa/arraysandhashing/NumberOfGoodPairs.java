package dsa.arraysandhashing;

/**
 * @author vkiprono
 * @created 2/8/24
 */

public class NumberOfGoodPairs {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 3};
        int[] nums1 = {1,1,1,1};
        int[] nums2 = {1,2,3};
        System.out.println(numIdenticalPairs(nums));
        System.out.println(numIdenticalPairs(nums1));
        System.out.println(numIdenticalPairs(nums2));

    }

    public static int numIdenticalPairs(int[] nums) {

        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((i < j) && nums[i] == nums[j]) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
