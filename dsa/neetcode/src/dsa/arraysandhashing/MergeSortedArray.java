package dsa.arraysandhashing;

/**
 * @author vkiprono
 * @created 3/22/24
 */

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        MergeSortedArray sortedArray = new MergeSortedArray();
        sortedArray.merge(nums1, m, nums2, n);
        //Output: [1,2,2,3,5,6]
    }

    /**
     *
     * Space Complexity - O(1)
     * Time Complexity - O(m + n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int first = m - 1;
        int second = n - 1;
        int k = (m + n) - 1;

        while (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[k] = nums1[first];
                first--;
            } else {
                nums1[k] = nums2[second];
                second--;
            }
            k--;
        }

        while (first >= 0) {
            nums1[k] = nums1[first];
            first--;
            k--;
        }

        while (second >= 0) {
            nums1[k] = nums2[second];
            second--;
            k--;
        }

    }
}
