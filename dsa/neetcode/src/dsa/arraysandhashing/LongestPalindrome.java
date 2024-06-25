package dsa.arraysandhashing;

/**
 * Leetcode 409. Longest Palindrome
 * <p>
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome
 * that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        String s = "abccccdd";
        System.out.println(palindrome.longestPalindrome(s));

    }

    public int longestPalindrome(String s) {
        int longestPalindrome = 0;
        char[] charCounts = new char[128];// lower and uppercase

        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }

        for (int count : charCounts) {
            longestPalindrome += count / 2 * 2;

            if (longestPalindrome % 2 == 0 && count % 2 == 1) {
                longestPalindrome++;
            }
        }

        return longestPalindrome;
    }

}
