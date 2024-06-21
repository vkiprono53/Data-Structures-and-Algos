package dsa.slidingwindow;

import java.util.*;

/**
 * LEETCODE 438. Find All Anagrams in a String
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class FindAllAnagrams {
    public static void main(String[] args) {
        FindAllAnagrams anagrams = new FindAllAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(anagrams.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null) {
            return result;
        }
        int sLen = s.length();
        int pLen = p.length();

        Map<Character, Integer> pCount = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char c = p.charAt(i);
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        Map<Character, Integer> subCount = new HashMap<>();

        for (int right = 0; right < sLen; right++) {
            char c = s.charAt(right);

            subCount.put(c, subCount.getOrDefault(c, 0) + 1);

            if (right - left + 1 == pLen) {
                if (isAnagram(subCount, pCount)) {
                    result.add(left);
                }
                subCount.put(s.charAt(left), subCount.get(s.charAt(left)) - 1);
                left++;

            }
        }
        return result;
    }
    private boolean isAnagram(Map<Character, Integer> subCount, Map<Character, Integer> pCount) {
        for (char c : pCount.keySet()) {
            if (subCount.get(c) != pCount.get(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution 2: Using Sliding window
     * Time Complexity - O(n)
     * Space Complexity - O(26) ~ O(1)
     */

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length() || s.length() < 1 || p.length() < 1) {
            return result;
        }
        int pLen = p.length();
        int sLen = s.length();
        //p char count:
        int[] pCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        //p window in s:
        int[] sWindow = new int[26];
        for (int i = 0; i < pLen - 1; i++) {
            sWindow[s.charAt(i) - 'a']++;
        }

        for (int i = pLen - 1; i < sLen; i++) {
            sWindow[s.charAt(i) - 'a']++;
            if (Arrays.equals(sWindow, pCount)) {
                result.add(i - pLen + 1);
            }
            sWindow[s.charAt(i - pLen + 1) - 'a']--;
        }

        return result;
    }
}
