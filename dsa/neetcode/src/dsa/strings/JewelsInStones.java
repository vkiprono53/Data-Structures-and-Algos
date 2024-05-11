package dsa.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * LEETCODE 771. Jewels and Stones
 * <p>
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 */
public class JewelsInStones {
    public static void main(String[] args) {
        JewelsInStones jewelsInStones = new JewelsInStones();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(jewelsInStones.numJewelsInStones(jewels, stones));
    }

    /**
     *Time complexity - O(n + m)
     * Space complexity - O(n)
     */
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        if (jewels == null) {
            return count;
        }

        Set<Character> mySet = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            mySet.add(j);
        }
        for (char s : stones.toCharArray()) {
            if (mySet.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewels.contains(String.valueOf(s))) {
                count++;
            }
        }
        return count;
    }
}
