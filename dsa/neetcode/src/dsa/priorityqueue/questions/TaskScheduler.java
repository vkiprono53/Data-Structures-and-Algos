package dsa.priorityqueue.questions;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
/**
 * @author vkiprono
 * @created 2/21/24
 */

/**
 * LEETCODE 621. Task Scheduler
 * <p>
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents
 * a different task. Tasks could be done in any order. Each task is done in one unit of time. For each
 * unit of time, the CPU could complete either one task or just be idle.
 * <p>
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks
 * (the same letter in the array), that is that there must be at least n units of time between any
 * two same tasks.
 * <p>
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 * Example 1:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 */
public class TaskScheduler {
    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));

    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        for (char c : tasks) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        maxHeap.addAll(map.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    tempList.add(maxHeap.remove());
                }
            }

            for (int num : tempList) {
                if (--num   > 0) {
                    maxHeap.offer(num);
                }
            }
            cycles += maxHeap.isEmpty() ? tempList.size() : n + 1;
        }
        return cycles;
    }

}
