package dsa.slidingwindow;

import java.util.Map;
import java.util.HashMap;

/**
 * Given a word and a text, return the count of occurrences of the anagrams of the word in the text.
 * <p>
 * An anagram of a word is a word that’s formed by rearranging the letters of the original word.
 * For example: the anagrams of the word for are
 * <p>
 * for
 * fro
 * ofr
 * orf
 * rof
 * rfo
 * <p>
 * Note that, the anagrams use all the original letters exactly once.
 * Example 1:
 * Input: text = forxxorfxdofr, word = for
 * Output : 3
 * Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.
 */
public class CountOccurrencesOfAnagram {

    public static void main(String[] args) {
        CountOccurrencesOfAnagram occurrencesOfAnagram = new CountOccurrencesOfAnagram();
        String text = "forxxorfxdofr";
        String word = "for";
        System.out.println(occurrencesOfAnagram.countOccurrenceOfAnagram2(text, word));

    }

    /**
     * Space Complexity - O(n)
     * Time Complexity -O(n * m) n - Length of text and m - length of word
     */
    public int countOccurrenceOfAnagram(String text, String word) {
        int n = text.length();
        int k = word.length();
        int count = 0;

        Map<Character, Integer> wordCharCount = new HashMap<>();
        for (int i = 0; i < k; i++) {
            wordCharCount.put(word.charAt(i), wordCharCount.getOrDefault(word.charAt(i), 0) + 1);
        }

        for (int i = 0; i <= n - k; i++) {
            Map<Character, Integer> subStrCharCount = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                char c = text.charAt(j);
                subStrCharCount.put(c, subStrCharCount.getOrDefault(c, 0) + 1);
            }
            if (isAnagram(subStrCharCount, wordCharCount)) {
                count++;
            }
        }
        return count;
    }


    public int countOccurrenceOfAnagram2(String text, String word) {
        int n = text.length();
        int k = word.length();
        int count = 0;

        Map<Character, Integer> wordCharCount = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char c = word.charAt(i);
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
        }


        int start = 0;
        Map<Character, Integer> subStrCharCount = new HashMap<>();

        for (int end = 0; end < n; end++) {
            char c = text.charAt(end);
            subStrCharCount.put(c, subStrCharCount.getOrDefault(c, 0) + 1); // Include the next char in the window

            if (end - start + 1 == k) {
                if (isAnagram(wordCharCount, subStrCharCount)) {
                    count++;
                }


                // Reduce count for the char at windowStart since we are sliding the window now
                subStrCharCount.put(text.charAt(start), subStrCharCount.get(text.charAt(start)) - 1);
                start++; // Slide the window ahead

            }

        }
        return count;
    }


    private boolean isAnagram(Map<Character, Integer> word1Count, Map<Character, Integer> word2Count) {
        for (char c : word1Count.keySet()) {
            if (word1Count.get(c) != word2Count.get(c)) {
                return false;
            }
        }
        return true;
    }
}
