package dsa.slidingwindow;

public class MaxSubArrayOfK {
    public static void main(String[] args) {

        MaxSubArrayOfK array = new MaxSubArrayOfK();
        int[] nums = {3, 5, 2, 1, 7};
        int k = 2;
        System.out.println(array.findMaxSum(nums, k));
    }

    /**
     * Space Complexity - O(1)
     * Time Complexity - O(n * K)
     */
    public int findMaxSumSubarrayOfSizeKBruteForce(int[] nums, int k) {
        int maxSum = 0;
        int sumSubArray;

        for (int i = 0; i < nums.length - k; i++) {
            sumSubArray = 0;
            for (int j = i; j < i + k; j++) {
                sumSubArray += nums[j];
            }
            maxSum = Math.max(maxSum, sumSubArray);
        }

        return maxSum;
    }

    public int findMaxSum(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int windowSum = 0;
        int maxSum = 0;
        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            if ((right - left) + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
