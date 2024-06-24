package dsa.stack.questions;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Leetcode 232. Implement Queue using Stacks
 * <p>
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * <p>
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 */
public class QueueUsingStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /**
     * Time Complexity - O(1)
     * Space Complexity - O(n) - n - number of queues
     */

    public void push(int x) {
        stack2.push(x);
    }

    public int pop() {
        move();
        return stack1.pop();
    }

    public int peek() {
        move();
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void move(){
        if(stack1.isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }
}
