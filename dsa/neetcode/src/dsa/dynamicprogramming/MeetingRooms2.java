package dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * Leetcode 253 . Meeting Rooms II
 * <p>
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 * <p>
 * Example 1 :
 * <p>
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 */
public class MeetingRooms2 {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals1 = {{7, 10},  {2, 4}};
        int[][] intervals3 = {{8, 12},  {10, 20}, {3, 19}, {11, 30}, {1, 10},  {2, 7}};
        MeetingRooms2 rooms2 = new MeetingRooms2();
        System.out.println(rooms2.minMeetingRooms(intervals3));

    }

    /**
     *Time complexity - O(n log n)
     * Space complexity - O(n)
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        //Define start and  end:
        int n = intervals.length;
        Integer[] start = new Integer[n];
        Integer[] end = new Integer[n];
        int minRooms = 0;
        int startPointer = 0;
        int endPointer = 0;

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start, (a, b)->a-b) ;
        Arrays.sort(end, (a, b)->a-b) ;

        while (startPointer < n) {
            minRooms++;

            if (start[startPointer] >= end[endPointer]) {
                minRooms--;
                endPointer++;
            }

            startPointer++;
        }
        return minRooms;

    }
}
