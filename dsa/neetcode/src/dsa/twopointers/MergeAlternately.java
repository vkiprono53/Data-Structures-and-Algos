package dsa.twopointers;

/**
 * Leetcode 1768. Merge Strings Alternately
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 */
public class MergeAlternately {
    public static void main(String[] args) {

        MergeAlternately alternately = new MergeAlternately();
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(alternately.mergeAlternately(word1, word2));
    }

    /**
     *Time Complexity - O(n)
     * Space Complexity - O(n) - length of the largest string
     */
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int first = 0;
        int second = 0;
        if (len1 < 1) {
            return word2;
        }
        if (len2 < 1) {
            return word1;
        }
        StringBuilder output = new StringBuilder();
        while (first < len1 && second < len2) {
            output.append(word1.charAt(first));
            output.append(word2.charAt(second));
            first++;
            second++;
        }
        while (first < len1) {
            output.append(word1.charAt(first));
            first++;
        }
        while (second < len2) {
            output.append(word1.charAt(second));
            second++;
        }

        return output.toString();
    }
}
