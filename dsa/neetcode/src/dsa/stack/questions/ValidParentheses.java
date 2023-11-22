package dsa.stack.questions;

import java.util.Deque;
import java.util.ArrayDeque;
/**
 * @author vkiprono
 * @created 11/22/23
 */

/**
 * LEETCODE 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {

        String iInput = "(])";
        System.out.println(isValid(iInput));

    }

    /**
     * Time complexity  - O(n)
     * Space complexity - O(n)
     *
     * @param input
     * @return
     */
    public static boolean isValid(String input) {
        Deque<Character> myStack = new ArrayDeque<>();

        for (char in : input.toCharArray()) {
            if (in == '(' || in == '{' || in == '[') {
                myStack.push(in);
            } else {
                if (myStack.isEmpty()) {
                    return false;
                } else {
                    char top = myStack.peek();

                    if (top == '(' && in == ')'
                            || top == '{' && in == '}'
                            || top == '[' && in == ']') {
                        myStack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return myStack.isEmpty();
    }
}
