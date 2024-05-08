package dsa.stack.questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LEETCODE 150. Evaluate Reverse Polish Notation
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a
 * Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 */
public class ReversePolish {
    public static void main(String[] args) {
        ReversePolish reversePolish = new ReversePolish();
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(reversePolish.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> myStack = new ArrayDeque<>();
        int result = 0;
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int first = myStack.pop();
                    int second = myStack.pop();
                    result = second + first;
                    myStack.push(result);
                }
                case "-" -> {
                    int first = myStack.pop();
                    int second = myStack.pop();
                    result = second - first;
                    myStack.push(result);
                }
                case "*" -> {
                    int first = myStack.pop();
                    int second = myStack.pop();
                    result = second * first;
                    myStack.push(result);
                }
                case "/" -> {
                    int first = myStack.pop();
                    int second = myStack.pop();
                    result = second / first;
                    myStack.push(result);
                }
                default -> {
                    int num = Integer.parseInt(token);
                    myStack.push(num);
                    result = num;
                }
            }
        }
        return result;
    }
}
