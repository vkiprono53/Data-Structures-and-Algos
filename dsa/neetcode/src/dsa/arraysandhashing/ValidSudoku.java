package dsa.arraysandhashing;

import java.util.Set;
import java.util.HashSet;
/**
 * @author vkiprono
 * @created 3/9/24
 */

/**
 * LEETCODE 36. Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
 * to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];

                if (currentVal != '.') {
                    if (!(seen.add(currentVal + "#" + i)) ||
                            !(seen.add(currentVal + "#" + j)) ||
                            !(seen.add(currentVal + "#" + (i / 3) + "-" + (j / 3)))) {
                        return false;
                    }
                }

            }

        }
        return true;
    }

}
