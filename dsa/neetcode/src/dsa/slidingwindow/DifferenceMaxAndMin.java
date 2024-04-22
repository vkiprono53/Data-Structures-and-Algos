package dsa.slidingwindow;

public class DifferenceMaxAndMin {
    public static void main(String[] args) {
        int[] nums = {3, 8, 9, 15};
        int k = 2;
        DifferenceMaxAndMin maxAndMin = new DifferenceMaxAndMin();
        System.out.println(maxAndMin.differenceMaxAndMin2(nums, k));
    }

    /**
     * Time Complexity - O(n * k)
     * Space Complexity - O(1)
     */
    public double differenceMaxAndMin(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (k > n){
            return -1;
        }
        for (int i = 0; i <= n - k; i++) {
            double currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += nums[j];
            }
            min = Math.min(min, (currentSum / k));
            max = Math.max(max, (currentSum / k));
        }
        return max - min;
    }

    /**
     * Space Complexity - O(1)
     * Time Complexity - O(n)
     */
    public double differenceMaxAndMin2(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        double currentSum = 0;
        double currentMin = Integer.MAX_VALUE;
        double currentMax = Integer.MIN_VALUE;
        int n = nums.length;
        if (k > n){
            return -1;
        }
        int left = 0;
        double currentAverage;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            if ((right - left) + 1 == k) {
                currentAverage = (currentSum / k);
                currentMin = Math.min(currentMin, currentAverage);
                currentMax = Math.max(currentMax, currentAverage);
                currentSum -= nums[left];
                left++;
            }
        }
        return (currentMax - currentMin);
    }
}
