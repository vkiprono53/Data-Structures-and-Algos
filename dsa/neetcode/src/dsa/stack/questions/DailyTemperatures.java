package dsa.stack.questions;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * LEETCODE 739. Daily Temperatures
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day
 * to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temps = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString((dailyTemperatures.dailyTemperatures1(temps))));

    }

    /**
     * Time Complexity - o(n^2)
     * Space COmplexity - O(1)
     *
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null){
            return null;
        }
        int n = temperatures.length;
        int[]  result = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if(temperatures[j] > temperatures[i]){
                    result[i] = j - i;
                    break;
                }
            }

        }
        return result;
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     *
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        Deque<Integer> myStack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] map = new int[n];

        for (int i = 0; i < n; i++){
            while(!myStack.isEmpty() && temperatures[myStack.peek()] < temperatures[i]){
                int topIndex = myStack.pop();
                int difference = i - topIndex;
                map[topIndex] = difference;
            }
            myStack.push(i);
        }

        return map;
    }
}
