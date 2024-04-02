package dsa.twopointers;

/**
 * LEETCODE 680. Valid Palindrome II
 * <p>
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: false
 */
public class ValidPalindrome2 {
    public static void main(String[] args) {

        ValidPalindrome2 palindrome2 = new ValidPalindrome2();
        String s = "abca";
        System.out.println(palindrome2.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;

        while (start < last && (s.charAt(start) == s.charAt(last))) {
            last--;
            start++;
        }
        if (start >= last) {
            return true;
        }

        int i = start + 1;
        int j = last;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) {
            return true;
        }
        i = start;
        j = last - 1;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        return i >= j;
    }
}
