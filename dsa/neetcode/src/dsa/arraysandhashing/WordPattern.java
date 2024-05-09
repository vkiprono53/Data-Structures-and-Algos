package dsa.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * LLETCODE 290. Word Pattern
 * <p>
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and
 * a non-empty word in s.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 */
public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        String pattern1 = "abba";
        String s1 = "dog cat cat fish";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> stringToWord = new HashMap<>();
        int n = pattern.length();
        String[] arrS = s.split(" ");

        if (n != arrS.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if (charToWord.containsKey(c) &&
                    !charToWord.get(c).equalsIgnoreCase(arrS[i])) {
                return false;
            }
            if (stringToWord.containsKey(arrS[i]) && !stringToWord.get(arrS[i]).equals(c)) {
                return false;
            }
            charToWord.put(c, arrS[i]);
            stringToWord.put(arrS[i], c);

        }
        return true;
    }
}
