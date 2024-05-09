package dsa.stack.questions;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LEETCODE 946. Validate Stack Sequences
 * <p>
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have
 * been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -> 4,
 * push(5),
 * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        ValidateStackSequences stackSequences = new ValidateStackSequences();
        System.out.println(stackSequences.validateStackSequences(pushed, popped));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> myStack = new ArrayDeque<>();
        int j = 0;
        int n = pushed.length;

        for (int num : pushed) {
            myStack.push(num);

            while (!myStack.isEmpty()  && myStack.peek() == popped[j]) {
                myStack.pop();
                j++;
            }
        }
        return j == n;
    }
}
