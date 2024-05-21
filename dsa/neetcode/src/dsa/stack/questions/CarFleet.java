package dsa.stack.questions;

import java.util.TreeMap;
import java.util.Map;

/**
 * LEETCODE 853. Car Fleet
 * There are n cars going to the same destination along a one-lane road.
 * The destination is target miles away.
 * <p>
 * You are given two integer array position and speed, both of length n,
 * where position[i] is the position of the ith car and speed[i] is the speed of the ith car
 * (in miles per hour).
 * <p>
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper
 * at the same speed. The faster car will slow down to match the slower car's speed.
 * The distance between these two cars is ignored (i.e., they are assumed to have the same position).
 * <p>
 * A car fleet is some non-empty set of cars driving at the same position and same speed.
 * Note that a single car is also a car fleet.
 * <p>
 * If a car catches up to a car fleet right at the destination point, it will still be considered as
 * one car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
 * The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6.
 * The fleet moves at speed 1 until it reaches target.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 */
public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        CarFleet carFleet = new CarFleet();
        System.out.println(carFleet.carFleet(target,position,speed));
    }

    /**
     *
     * @param target
     * @param position
     * @param speed
     * @return]
     * Space Complexity - O(n)
     * Time Complexity - O(n)
     */

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = position.length;
        for (int i = 0; i < n; i++) {
            map.put(target - position[i], speed[i]);
        }
        int count = 0;
        double r = -1D;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int distance = entry.getKey();
            int carSpeed = entry.getValue();
            double timeRem = (double) distance / carSpeed;
            if (timeRem > r) {
                count++;
                r = timeRem;
            }

        }
        return count;
    }
}
