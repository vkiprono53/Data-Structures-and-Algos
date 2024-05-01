package dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * LEETCODE 904. Fruit Into Baskets
 * <p>
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith
 * tree produces.
 * <p>
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you
 * must follow:
 * <p>
 * You only have two baskets, and each basket can only hold a single type of fruit.
 * There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree
 * (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * <p>
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 * <p>
 * Example 1:
 * <p>
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * <p>
 * Example 2:
 * <p>
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 */
public class FruitIntoBasket {
    public static void main(String[] args) {
        FruitIntoBasket fruit = new FruitIntoBasket();
        int[] fruits = {0, 1, 2, 2};
        System.out.println(fruit.totalFruit(fruits));
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(n)
     */
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int currentFruits = 0;
        int n = fruits.length;
        Set<Integer> fruitSet;
        for (int l = 0; l < n; l++) {
            fruitSet = new HashSet<>();
            for (int r = l; r < n; r++) {
                fruitSet.add(fruits[r]);
                if (fruitSet.size() > 2) {
                    break;
                }
                currentFruits = r - l + 1;

            }
            maxFruits = Math.max(maxFruits, currentFruits);

        }
        return maxFruits;
    }

    /**
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     */
    public int totalFruit2(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        int n = fruits.length;
        Map<Integer, Integer> fruitMap = new HashMap<>();
        for (int right = 0; right < n; right++) {
            fruitMap.put(fruits[right], fruitMap.getOrDefault(fruits[right], 0) + 1);

            if (fruitMap.size() > 2) {
                while (fruitMap.size() > 2) {
                    fruitMap.put(fruits[left], fruitMap.get(fruits[left]) - 1);
                    if (fruitMap.get(fruits[left]) == 0) {
                        fruitMap.remove(fruits[left]);
                    }
                    left++;
                }
            }
            maxFruits = Math.max(maxFruits, right - left + 1);

        }
        return maxFruits;
    }
}
