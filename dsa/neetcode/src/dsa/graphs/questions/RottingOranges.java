package dsa.graphs.questions;

import java.util.Deque;
import java.util.ArrayDeque;
/**
 * @author vkiprono
 * @created 3/13/24
 */

/**
 * LEETCODE 994. Rotting Oranges
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 */
public class RottingOranges {
    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.addLast(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }
        int result = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty() && freshCount != 0) {
            result++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] rotten = queue.removeFirst();
                int r = rotten[0];
                int c = rotten[1];

                for (int[] dir : dirs) {
                    int x = r + dir[0];
                    int y = c + dir[1];

                    if (x >= 0 && x < rows && y >= 0 && y < columns && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.addLast(new int[]{x, y});
                        freshCount--;
                    }
                }
            }
        }

        return freshCount == 0 ? result : -1;

    }
}
