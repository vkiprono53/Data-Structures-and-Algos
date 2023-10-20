package dsa;
import java.util.Arrays;
import java.util.HashMap;
/**
 * ---------LEETCONE 242 : VALID ANAGRAM----------
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length, t.length <= 5 * 104
 *     s and t consist of lowercase English letters.
 *
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */


public class ValidAnagram {
    public static void main(String[] args) {

        String s = "a";
        String t = "ab";

        String s1 = "rat";
        String t1 = "car";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram2(s1, t1));
    }

    /**
     * Solution 1:
     * Time complexity O(n);
     * Space Complexity O(n);
     */
    public static boolean isAnagram(String s, String t) {

        if (s.isEmpty() && t.isEmpty()){
            return true;
        }
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        count(tMap, t);
        count(sMap, s);

        return sMap.equals(tMap);
    }

    public static void  count(HashMap<Character, Integer> map, String myString){
        for (int i = 0; i < myString.length(); i++){
            if(map.containsKey(myString.charAt(i))){
                map.put(myString.charAt(i), map.get(myString.charAt(i)) + 1);
            }
            else{
                map.put(myString.charAt(i), 1);
            }
        }
    }


    /**
     * Solution 2:
     * Time complexity O(n);
     * Space Complexity O(1);
     */

    public static boolean isAnagram2(String s, String t) {

        //Frequency of each letter:
        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++){
            frequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++){
            frequency[s.charAt(i) - 'a']--;
        }

        for (int j : frequency) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }
}
