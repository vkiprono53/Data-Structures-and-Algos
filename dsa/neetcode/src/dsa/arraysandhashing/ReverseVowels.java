package dsa.arraysandhashing;

import java.lang.StringBuilder;
/**
 * @author vkiprono
 * @created 2/7/24
 */

/**
 * LEETCODE 345. Reverse Vowels of a String
 */
public class ReverseVowels {
    public static void main(String[] args) {

        String word = "hello";
        System.out.println(reverseVowels(word));
    }

    public static String reverseVowels(String s) {
        StringBuilder vowelString = new StringBuilder();
        StringBuilder newVowelString = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A' ||
                    s.charAt(i) == 'e' || s.charAt(i) == 'E' ||
                    s.charAt(i) == 'i' || s.charAt(i) == 'I' ||
                    s.charAt(i) == 'o' || s.charAt(i) == 'O' ||
                    s.charAt(i) == 'u' || s.charAt(i) == 'U') {
                vowelString.append(s.charAt(i));
            }
        }

        newVowelString = vowelString.reverse();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A' ||
                    s.charAt(i) == 'e' || s.charAt(i) == 'E' ||
                    s.charAt(i) == 'i' || s.charAt(i) == 'I' ||
                    s.charAt(i) == 'o' || s.charAt(i) == 'O' ||
                    s.charAt(i) == 'u' || s.charAt(i) == 'U') {
                result.append(newVowelString.charAt(j));
                j++;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}