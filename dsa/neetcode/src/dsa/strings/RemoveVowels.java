package dsa.strings;

import java.util.Set;
import java.util.HashSet;

/**
 * Leetcode 1119
 */
public class RemoveVowels {
    public static void main(String[] args) {
        RemoveVowels removeVowels = new RemoveVowels();
        String input = "Hello, World!";
        System.out.println(removeVowels.removeVowels1(input));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public String removeVowels(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' ||
                    input.charAt(i) == 'e' ||
                    input.charAt(i) == 'i' ||
                    input.charAt(i) == 'o' ||
                    input.charAt(i) == 'u'
            ) {
                continue;
            }
            output.append(input.charAt(i));

        }
        return output.toString();
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public String removeVowels1(String input) {
        if (input == null) {
            return null;
        }
        Set<Character> mySet = new HashSet<>();
        StringBuilder output = new StringBuilder();
        mySet.add('a');
        mySet.add('e');
        mySet.add('i');
        mySet.add('o');
        mySet.add('u');

        for (int i = 0; i < input.length(); i++) {
            if (!mySet.contains(input.charAt(i))) {
                output.append(input.charAt(i));
            }
        }
        return output.toString();
    }
}
