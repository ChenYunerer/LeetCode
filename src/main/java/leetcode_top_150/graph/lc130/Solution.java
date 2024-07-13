package leetcode_top_150.graph.lc130;

import java.util.ArrayList;
import java.util.List;

/**
 * 130. 被围绕的区域
 * https://leetcode.cn/problems/surrounded-regions/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Solution {


    /**
     * 非最优解
     */
    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        List<Integer[]> unTouchEdgeList = new ArrayList<>();
        boolean[][] visited = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (!visited[row][column] && board[row][column] == 'O') {
                    List<Integer[]> path = new ArrayList<>();
                    boolean touchEdge = dfs(board, visited, row, column, path);
                    if (!touchEdge) {
                        unTouchEdgeList.addAll(path);
                    }
                }
            }
        }
        for (int i = 0; i < unTouchEdgeList.size(); i++) {
            int row = unTouchEdgeList.get(i)[0];
            int column = unTouchEdgeList.get(i)[1];
            board[row][column] = 'X';
        }
    }

    private boolean dfs(char[][] board, boolean[][] visited, int row, int column, List<Integer[]> path) {
        int rows = board.length;
        int columns = board[0].length;
        if (row < 0 || row > rows - 1 || column < 0 || column > columns - 1) {
            return false;
        }
        if (board[row][column] == 'X') {
            return false;
        }
        if (visited[row][column]) {
            return false;
        }
        visited[row][column] = true;
        path.add(new Integer[]{row, column});
        boolean touchEdge = row == 0 || column == 0 || row == rows - 1 || column == columns - 1;
        boolean subTouchEdge1 = dfs(board, visited, row + 1, column, path);
        boolean subTouchEdge2 = dfs(board, visited, row - 1, column, path);
        boolean subTouchEdge3 = dfs(board, visited, row, column + 1, path);
        boolean subTouchEdge4 = dfs(board, visited, row, column - 1, path);
        return touchEdge || subTouchEdge1 || subTouchEdge2 || subTouchEdge3 || subTouchEdge4;
    }


    /**
     * best
     */
    public void solve1(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        for (int row = 0; row < rows; row++) {
            dfs1(board, row, 0);
            dfs1(board, row, columns - 1);
        }
        for (int column = 0; column < columns; column++) {
            dfs1(board, 0, column);
            dfs1(board, rows - 1, column);
        }
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 'A') {
                    board[row][column] = 'O';
                } else if (board[row][column] == 'O') {
                    board[row][column] = 'X';
                }
            }
        }
    }

    private void dfs1(char[][] board, int row, int column) {
        int rows = board.length;
        int columns = board[0].length;
        if (row < 0 || column < 0 || row >= rows || column >= columns) {
            return;
        }
        if (board[row][column] != 'O') {
            return;
        }
        board[row][column] = 'A';
        dfs1(board, row + 1, column);
        dfs1(board, row - 1, column);
        dfs1(board, row, column + 1);
        dfs1(board, row, column - 1);
    }

}
