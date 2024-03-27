package dsa.arraysandhashing;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LEETCODE 392. Is Subsequence
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 */
public class Subsequence {
    public static void main(String[] args) {

        Subsequence subsequence = new Subsequence();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(subsequence.isSubsequence(s, t));
    }

    /**
     * Space Complexity - O(n)
     * Time Complexity - o(1)
     */
    public boolean isSubsequence(String s, String t) {
        int small = s.length();
        int large = t.length();
        int i = 0;
        for (int j = 0; j < large; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if (i == small) {
                return true;
            }
        }
        return false;
    }

    /**
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     */
    public boolean isSubsequence1(String s, String t) {
        Deque<Character> myQueue = new ArrayDeque<>();
        for (int i = 0; i < t.length(); i++) {
            myQueue.addLast(t.charAt(i));
        }

        int j = 0;
        while (!myQueue.isEmpty()) {
            if (myQueue.poll() == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }
}