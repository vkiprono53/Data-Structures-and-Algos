package dsa.stack.questions;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LEETCODE 682. Baseball Game
 * <p>
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game,
 * you start with an empty record.
 * <p>
 * You are given a list of strings operations, where operations[i] is the ith operation you must
 * apply to the record and is one of the following:
 * <p>
 * <p>
 * An integer x.
 * Record a new score of x.
 * '+'.
 * Record a new score that is the sum of the previous two scores.
 * 'D'.
 * Record a new score that is the double of the previous score.
 * 'C'.
 * Invalidate the previous score, removing it from the record.
 * <p>
 * Return the sum of all the scores on the record after applying all the operations.
 */
public class BaseballGame {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(baseballGame.calPoints(ops));
    }

    public int calPoints(String[] operations) {
        Deque<Integer> myStack = new ArrayDeque<>();
        int result = 0;

        for (String op : operations) {
            if (op.equals("+")) {
                int first = myStack.pop();
                int second = myStack.pop();
                int sum = first + second;
                myStack.push(second);
                myStack.push(first);
                myStack.push(sum);
            } else if (op.equals("D")) {
                int top = myStack.peek();
                int doubleTop = top * 2;
                myStack.push(doubleTop);
            } else if (op.equals("C")) {
                myStack.pop();
            } else {
                int x = Integer.parseInt(op);
                myStack.push(x);
            }
        }

        while (!myStack.isEmpty()) {
            result += myStack.pop();
        }
        return result;
    }
}
