package dsa.slidingwindow;

import java.util.Set;
import java.util.HashSet;
/**
 * @author vkiprono
 * @created 11/15/23
 */

/**
 * LEETCODE 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstring {
    public static void main(String[] args) {

        LongestSubstring longestSubstring = new LongestSubstring();
        String s = "au";
        System.out.println(longestSubstring.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> mySet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {

                if (mySet.contains(s.charAt(j))) { // if element if found so mark it as ans and break from the loop
                    maxLen = Math.max(maxLen, j - i);
                    break;
                }

                mySet.add(s.charAt(j));
                maxLen = Math.max(maxLen, (j - i) + 1);

            }
        }
        return maxLen;
    }

    /**
     * Sliding window:
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        int l = 0;
        Set<Character> mySet = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
            if (!mySet.contains(s.charAt(r))) {
                mySet.add(s.charAt(r));
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                while (mySet.contains(s.charAt(r))) {
                    mySet.remove(s.charAt(r));
                    l++;
                }
            }
            mySet.add(s.charAt(r));
        }
        return maxLen;
    }


}
