package dsa.slidingwindow;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains at
 * most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 *
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 */
public class KDistinctChars {
    public static void main(String[] args) {
        String str = "aabbcc";
        int k = 1;
        KDistinctChars distinctChars = new KDistinctChars();
        System.out.println(distinctChars.kDistinctChars(str, k));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int kDistinctChars(String str, int k) {
        int left = 0;
        int maxLen = 0;
        int n = str.length();
        Map<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < n; right++) {

            char rightChar = str.charAt(right);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);

            if (charMap.size() > k) { // Or  while (charMap.size() > k) {

                char charLeft = str.charAt(left);
                if (charMap.containsKey(charLeft)) {
                    charMap.put(charLeft, charMap.get(charLeft) - 1);

                    if (charMap.get(charLeft) == 0) {
                        charMap.remove(charLeft);
                    }
                }
                left++;

            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1) - Set will contain a maximum of 26 characters
     */
    public int kDistinctChars1(String str, int k) {
        int longest = 0;
        if (str == null) {
            return longest;
        }
        int n = str.length();

        for (int left = 0; left < n; left++) {
            Set<Character> mySet = new HashSet<>();

            for (int right = left; right < n; right++) {
                mySet.add(str.charAt(right));
                if (mySet.size() > k) {
                    break;
                }
                longest = Math.max(right - left + 1, longest);
            }
        }
        return longest;
    }
}
