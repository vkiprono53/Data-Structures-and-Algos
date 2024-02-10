package dsa.arraysandhashing;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

        String s = "car";
        String t = "rac";

        String s1 = "rat";
        String t1 = "car";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram(s1, t1));
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

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        tMap = count(t);
        sMap = count(s);

        return sMap.equals(tMap);
    }

    public static Map<Character, Integer>  count( String myString){
        Map<Character, Integer> myMap = new HashMap<>();
        for (int i = 0; i < myString.length(); i++){
            if(myMap.containsKey(myString.charAt(i))){
                myMap.put(myString.charAt(i), myMap.get(myString.charAt(i)) + 1);
            }
            else{
                myMap.put(myString.charAt(i), 1);
            }
        }
        return myMap;
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

    public static boolean isAnagram1(String s, String t){
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        if (s.length() != t.length()){
            return false;
        }
       sMap = myMap(s);
       tMap = myMap(t);
       return sMap.equals(tMap);

    }
    private static Map<Character, Integer> myMap(String word){
        Map<Character, Integer> myMap = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            if (myMap.containsKey(word.charAt(i))){
                myMap.put(word.charAt(i), myMap.get(word.charAt(i)) + 1);
            }
            else{
                myMap.put(word.charAt(i), 1);
            }
        }
        return myMap;
    }
}
