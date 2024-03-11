package dsa.graphs.questions;

/**
 * @author vkiprono
 * @created 3/11/24
 */

/**
 * LEETCODE 695. Max Area of Island
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of
 * the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {
    boolean[][] seen;

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        MaxAreaOfIsland area = new MaxAreaOfIsland();
        System.out.println(area.maxAreaOfIsland(grid));

    }

    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, area(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int area(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0 || seen[i][j]) {
            return 0;
        }
        seen[i][j] = true;
        return 1 + area(grid, i + 1, j)
                + area(grid, i - 1, j)
                + area(grid, i, j + 1)
                + area(grid, i, j - 1);
    }

}
