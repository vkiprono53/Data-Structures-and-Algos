package dsa.priorityqueue.questions;
import java.util.PriorityQueue;
import java.util.Collections;
/**
 * @author vkiprono
 * @created 2/19/24
 */

/** LEETCODE 1046. Last Stone Weight
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones
 * and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 *     If x == y, both stones are destroyed, and
 *     If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 *
 * At the end of the game, there is at most one stone left.
 *
 * Return the weight of the last remaining stone. If there are no stones left, return 0.

 */
 public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,2};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones){
            heap.add(stone);
        }
        while(heap.size() > 1){
            int y = heap.poll();
            int x = heap.peek();
            if (x == y){
                heap.poll();
            }
            else{
                int newElement = y - x;
                heap.poll();
                heap.add(newElement);
            }
        }
        if (heap.size() == 0){
            return 0;
        }

        return heap.peek();
    }
}
