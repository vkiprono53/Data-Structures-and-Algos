package dsa.arraysandhashing;

/**
 * LEETCODE 28. Find the Index of the First Occurrence in a String
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 */
public class IndexFirstOccurrence {
    public static void main(String[] args) {

        IndexFirstOccurrence firstOccurrence = new IndexFirstOccurrence();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(firstOccurrence.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int index = -1;
        int j = 0;
        int k = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j < needle.length() && haystack.charAt(k) == needle.charAt(j)) {
                if (j == 0) {
                    index = i;
                }
                j++;
                k++;
            }
            if (j == needle.length()) {
                return index;
            } else {
                index = -1;
                j = 0;
                k = i;
            }
        }
        return index;
    }
}
