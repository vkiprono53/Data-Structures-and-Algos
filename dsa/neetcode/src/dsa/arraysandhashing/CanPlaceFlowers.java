package dsa.arraysandhashing;

/**
 * LEETCODE 605. Can Place Flowers
 * <p>
 * You have a long flowerbed in which some of the plots are planted, and some are not. However,
 * flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can
 * be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {

        CanPlaceFlowers placeFlowers = new CanPlaceFlowers();
        int[] flowerbed = {0, 0, 1, 0, 1};
        int n = 1;
        System.out.println(placeFlowers.canPlaceFlowers(flowerbed, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int planted = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == len - 1 || flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                planted++;
            }
        }

        return planted == n;
    }
}
