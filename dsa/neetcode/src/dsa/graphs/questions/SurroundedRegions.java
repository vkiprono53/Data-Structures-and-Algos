package dsa.graphs.questions;

/**
 * @author vkiprono
 * @created 3/12/24
 */

import java.util.Arrays;

/**
 * LEETCODE 130. Surrounded Regions:
 * <p>
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions regions = new SurroundedRegions();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

    }

    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        //1st and last column
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, rows, columns);
            }
            if (board[i][columns - 1] == 'O') {
                dfs(board, i, columns - 1, rows, columns);

            }
        }

        //1st and last row
        for (int j = 0; j < columns; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, rows, columns);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows-1, j, rows, columns);

            }
        }

        //Traverse the whole board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, int rows, int columns) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j, rows, columns);
        dfs(board, i - 1, j, rows, columns);
        dfs(board, i, j + 1, rows, columns);
        dfs(board, i, j - 1, rows, columns);
    }
}
