package dsa.stack.questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode 227. Basic Calculator II
 * <p>
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * All intermediate results will be in the range of [-231, 231 - 1].
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * Example 1:
 * <p>
 * Input: s = "3+2*2"
 * Output: 7
 * <p>
 * Example 2:
 * <p>
 * Input: s = " 3/2 "
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */

public class BasicCalculator2 {

    public static void main(String[] args) {
        BasicCalculator2 calculator2 = new BasicCalculator2();
        String s = "3+2*2";
        System.out.println(calculator2.calculate(s));

    }

    public int calculate(String s) {
        Deque<Integer> myStack = new ArrayDeque<>();
        char operation = '+';
        int num = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                num = (num * 10) + currentChar - '0';
            }
            if (i == n - 1 || currentChar == '+'
                    || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                if (operation == '+') {
                    myStack.push(num);
                } else if (operation == '-') {
                    myStack.push(-num);
                } else if (operation == '*') {
                    myStack.push(myStack.pop() * num);
                } else {
                    myStack.push(myStack.pop() / num);
                }
                operation = currentChar;
                num = 0;
            }

        }
        int result = 0;

        while (!myStack.isEmpty()) {
            result += myStack.pop();
        }

        return result;
    }
}
