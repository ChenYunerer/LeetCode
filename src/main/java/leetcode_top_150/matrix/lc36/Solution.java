package leetcode_top_150.matrix.lc36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. 有效的数独
 * https://leetcode.cn/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board1 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        boolean ans = new Solution().isValidSudoku(board2);
        System.out.println(ans);
    }

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        Map<Integer, Set<Character>> rowSetMap = new HashMap<>();
        Map<Integer, Set<Character>> columnSetMap = new HashMap<>();
        Map<Integer, Set<Character>> squareSetMap = new HashMap<>();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char curChar = board[row][column];
                if (curChar == '.') {
                    continue;
                }
                Set<Character> rowSet = rowSetMap.computeIfAbsent(row, (k) -> new HashSet<>());
                if (rowSet.contains(curChar)) {
                    return false;
                } else {
                    rowSet.add(curChar);
                }
                Set<Character> columnSet = columnSetMap.computeIfAbsent(column, (k) -> new HashSet<>());
                if (columnSet.contains(curChar)) {
                    return false;
                } else {
                    columnSet.add(curChar);
                }
                int squareIndex = column / 3 + (row / 3) * 3;
                Set<Character> squareSet = squareSetMap.computeIfAbsent(squareIndex, (k) -> new HashSet<>());
                if (squareSet.contains(curChar)) {
                    return false;
                } else {
                    squareSet.add(curChar);
                }
            }
        }
        return true;
    }

    /**
     * best
     */
    public boolean isValidSudoku1(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int[][] rowCount = new int[9][9];
        int[][] columCount = new int[9][9];
        int[][][] squareCount = new int[3][3][9];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                char curChar = board[row][column];
                if (curChar == '.') {
                    continue;
                }
                rowCount[row][curChar - '1']++;
                columCount[column][curChar - '1']++;
                squareCount[row / 3][column / 3][curChar - '1']++;
                if (rowCount[row][curChar - '1'] > 1 || columCount[column][curChar - '1'] > 1 || squareCount[row / 3][column / 3][curChar - '1'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
