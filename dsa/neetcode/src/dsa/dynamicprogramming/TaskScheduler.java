package dsa.dynamicprogramming;

/**
 * Leetcode 621. Task Scheduler
 * <p>
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
 * Each cycle or interval allows the completion of one task. Tasks can be completed in any order,
 * but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
 * <p>
 * ​Return the minimum number of intervals required to complete all tasks.
 * <p>
 * Example 1:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * <p>
 * Output: 8
 * <p>
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.
 */
public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(scheduler.leastInterval(tasks, n));
    }

    /**
     * Time Complexity - O(n)
     * Space complexity - O(n)
     */
    public int leastInterval(char[] tasks, int n) {
        int minIntervals = 0;
        int maxFrequency = 0;
        //count frequency of each character
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            int index = task - 'A';
            taskCounts[index]++;
            maxFrequency = Math.max(maxFrequency, taskCounts[index]);
        }
        //Tasks with maxfrequency:
        int maxFrequencyTasks = 0;
        for (int count : taskCounts) {
            if (count == maxFrequency) {
                maxFrequencyTasks++;
            }
        }
        minIntervals = Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxFrequencyTasks);

        return minIntervals;
    }
}
