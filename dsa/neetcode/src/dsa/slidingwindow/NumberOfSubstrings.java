package dsa.slidingwindow;


/**
 * LEETCODE 1358. Number of Substrings Containing All Three Characters
 * <p>
 * Given a string s consisting only of characters a, b and c.
 * <p>
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc",
 * "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * <p>
 * Example 2:
 * <p>
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb",
 * "aacb" and "acb".
 * <p>
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: 1
 */
public class NumberOfSubstrings {
    public static void main(String[] args) {
        NumberOfSubstrings numberOfSubstrings = new NumberOfSubstrings();
        String s = "abcabc";
        System.out.println(numberOfSubstrings.numberOfSubstrings(s));
    }

    /**
     * TLE
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i <= n; i++) {
            String subStr;
            for (int j = i; j <= n; j++) {
                subStr = s.substring(i, j);
                if (subStr.contains("a") && subStr.contains("b") && subStr.contains("c")) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int numberOfSubstrings1(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count = 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }
        return count;
    }
}
