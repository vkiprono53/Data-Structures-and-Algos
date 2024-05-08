package dsa.stack.questions;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LEETCODE 2390. Removing Stars From a String
 * <p>
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * <p>
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leet**cod*e"
 * Output: "lecoe"
 * Explanation: Performing the removals from left to right:
 * - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
 * - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
 * - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
 * There are no more stars, so we return "lecoe".
 */
public class RemovingStars {
    public static void main(String[] args) {
        RemovingStars removingStars = new RemovingStars();
        String s = "leet**cod*e";
        System.out.println(removingStars.removeStars2(s));

    }

    /**
     * Using Stack
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public String removeStars(String s) {
        Deque<Character> myStack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                myStack.pop();
            } else {
                myStack.push(s.charAt(i));
            }
        }
        while (!myStack.isEmpty()) {
            output.append(myStack.pop());
        }
        return output.reverse().toString();
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public String removeStars2(String s) {
        char[] newString = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                index--;
            } else {
                newString[index] = s.charAt(i);
                index++;
            }
        }

        return new String(newString, 0, index);
    }
}
