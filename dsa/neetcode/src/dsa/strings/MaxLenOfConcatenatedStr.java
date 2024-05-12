package dsa.strings;

import java.util.*;

/**
 * LEETCODE 1239. Maximum Length of a Concatenated String with Unique Characters
 * <p>
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr
 * that has unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or
 * no elements without changing the order of the remaining elements.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 */
public class MaxLenOfConcatenatedStr {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("un","iq","ue");
        MaxLenOfConcatenatedStr concatenatedStr = new MaxLenOfConcatenatedStr();
        System.out.println(concatenatedStr.maxLength(myList));

    }

    public int maxLength(List<String> arr) {
        int maxLen = 0;
        List<String> myList = new ArrayList<>();
        myList.add("");

        for (String word : arr) {
            for (int i = 0; i < myList.size(); i++) {
                StringBuilder newWord = new StringBuilder();
                newWord.append(myList.get(i)).append(word);
                if (addToSet(newWord.toString())) {
                    myList.add(newWord.toString());
                    maxLen = Math.max(maxLen, newWord.length());
                }
            }
        }
        return maxLen;
    }

    private boolean addToSet(String input) {
        Set<Character> uniqueSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (uniqueSet.contains(input.charAt(i))) {
                return false;
            }
            uniqueSet.add(input.charAt(i));
        }
        return true;
    }
}
