package dsa.priorityqueue.questions;

import java.util.*;
/**
 * @author vkiprono
 * @created 2/20/24
 */

/**
 * LEETCODE 973. K Closest Points to Origin
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{0, 1}, {1, 0}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, 1)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] -
                p1[0] * p1[0] - p1[1] * p1[1]);

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        while (k > 0) {
            result[--k] = maxHeap.poll();
        }
        return result;
    }
}
