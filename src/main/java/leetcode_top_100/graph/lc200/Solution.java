package leetcode_top_100.graph.lc200;

/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1') {
                    ans++;
                    dfs(grid, row, column);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (row < 0 || row >= rows) {
            return;
        }
        if (column < 0 || column >= columns) {
            return;
        }
        char temp = grid[row][column];
        if (temp == '2') {
            return;
        }
        if (temp == '0') {
            return;
        }
        grid[row][column] = '2';
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);
        // grid[row][column] = temp;
    }
}
