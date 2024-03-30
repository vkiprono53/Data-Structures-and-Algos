package dsa.arraysandhashing;

import java.util.Map;
import java.util.HashMap;

/**
 * LEETCODE 205. Isomorphic Strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicString {
    public static void main(String[] args) {

        IsomorphicString isomorphicString = new IsomorphicString();
        String s = "egg";
        String t = "add";

        String s1 = "badc";
        String t1 = "baba";
        System.out.println(isomorphicString.isIsomorphic(s1, t1));
    }

    /**
     *
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     */
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
