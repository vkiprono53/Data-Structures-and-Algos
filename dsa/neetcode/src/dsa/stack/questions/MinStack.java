package dsa.stack.questions;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * LEETCODE 155. Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * <p>
 * You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    Deque<Integer> myStack = new ArrayDeque<>();
    Deque<Integer> minimumStack = new ArrayDeque<>();

    public MinStack() {
        minimumStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        myStack.push(val);
        minimumStack.push(Math.min(val, minimumStack.peek()));
    }

    public void pop() {
        myStack.pop();
        minimumStack.pop();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minimumStack.peek();
    }

}
