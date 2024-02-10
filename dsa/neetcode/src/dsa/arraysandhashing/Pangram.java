package dsa.arraysandhashing;

import java.util.Map;
import java.util.HashMap;

/**
 * @author vkiprono
 * @created 2/7/24
 */

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram,
 * or false otherwise.
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 */
public class Pangram {
    public static void main(String[] args) {

        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence1 = "leetcode";
        System.out.println(checkIfPangram(sentence));
        System.out.println(checkIfPangram(sentence1));

    }

    public static boolean checkIfPangram(String sentence) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < sentence.length(); i++){
            if (!map.containsKey(sentence.charAt(i))){
                map.put(sentence.charAt(i), 1);
            }
        }
        return map.size() == 26;
    }
}
