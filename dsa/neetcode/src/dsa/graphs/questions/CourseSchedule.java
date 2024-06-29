package dsa.graphs.questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
/**
 * @author vkiprono
 * @created 3/14/24
 */

/**
 * LEETCODE 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * <p>
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is pos
 */
public class CourseSchedule {
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        CourseSchedule schedule = new CourseSchedule();
        System.out.println(schedule.canFinish(numCourses, prerequisites));
    }

    /**
     * Time Complexity - O(v + e)
     * Space - O(v)- vertices
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        //Prerequisites
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereqCourse = prerequisite[1];
            adjList.get(prereqCourse).add(course);
            inDegree[course]++;
        }
        //Course - No Prerequisite:
        Deque<Integer> myQueue = new ArrayDeque<>();
        int processedCourses = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                myQueue.addLast(i);
            }
        }
        while (!myQueue.isEmpty()) {
            int course = myQueue.removeFirst();
            processedCourses++;

            for (int neighbor : adjList.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    myQueue.addLast(neighbor);
                }
            }
        }
        return processedCourses == numCourses;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(adj, i, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> prerequisite, int current, int[] visited) {
        /**
         * 0 - Unvisited
         * 1 - Processing
         * 2 - Processed
         */
        if (visited[current] == 1) {
            return true;
        }
        visited[current] = 1;

        for (int node : prerequisite.get(current)) {
            if (visited[node] != 2) {
                if (hasCycle(prerequisite, node, visited)) {
                    return true;
                }
            }
        }
        visited[current] = 2;
        return false;

    }
}
