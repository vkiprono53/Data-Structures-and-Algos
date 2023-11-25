package dsa.binarysearch;

/**
 * @author vkiprono
 * @created 11/23/23
 */

public class BinarySearchImpl {
    public static void main(String[] args) {

        int[] nums = { -1,0,3,5,9,12 };
        System.out.println(binarySearch(nums, 2));

    }

    public static int binarySearch(int[] nums, int key){
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;

        while(low <= high){
            mid = (high + low) / 2;
            if(key == nums[mid]){
                return mid;
            }
            else if(key > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
