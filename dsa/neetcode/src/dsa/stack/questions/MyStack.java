package dsa.stack.questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LEETCODE 225. Implement Stack using Queues
 * <p>
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * <p>
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 */
public class MyStack {
    Deque<Integer> first;
    Deque<Integer> second;

    public MyStack() {
        first = new ArrayDeque<>();
        second = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False
        // [null, null, null, 2, 2, false]
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public void push(int x) {
        second.offer(x);
        while (!first.isEmpty()) {
            second.offer(first.poll());
        }
        Deque<Integer> temp = first;
        first = second;
        second = temp;
    }

    public int pop() {
        int removeElement = first.removeFirst();
        return removeElement;
    }

    public int top() {
        int top = first.peek();
        return top;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}
