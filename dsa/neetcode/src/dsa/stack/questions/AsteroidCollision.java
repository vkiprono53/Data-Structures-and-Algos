package dsa.stack.questions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LEETCODE 735. Asteroid Collision
 * <p>
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction
 * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller
 * one will explode. If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * <p>
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * <p>
 * Example 2:
 * <p>
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * <p>
 * Example 3:
 * <p>
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision collision = new AsteroidCollision();
        int[] asteroids = {10,2,-5};
        System.out.println(Arrays.toString(collision.asteroidCollision(asteroids)));
    }

    /**
     * Time complexity - O(n)
     * Space Complexity - O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return null;
        }
        Deque<Integer> myStack = new ArrayDeque<>();
        int n = asteroids.length;

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                myStack.push(asteroids[i]);
            } else {
                while (!myStack.isEmpty() && myStack.peek() > 0 && myStack.peek() < Math.abs(asteroids[i])) {
                    myStack.pop();
                }
                if (myStack.isEmpty() || myStack.peek() < 0) {
                    myStack.push(asteroids[i]);
                } else if (myStack.peek() == Math.abs(asteroids[i])) {
                    myStack.pop();
                }
            }
        }
        int size = myStack.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = myStack.pop();
        }
        return result;
    }
}
