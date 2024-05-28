package basicalgorithm.graph.lc827;

/**
 * 827. 最大人工岛
 * https://leetcode.cn/problems/making-a-large-island/description/
 */
public class Solution {

    public int largestIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int ans = 0;
        boolean[][] visitedGrid = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; row < columns; column++) {
                if (grid[row][column] == 1 && !visitedGrid[row][column]) {
                    ans = dfs(grid, visitedGrid, row, column);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, boolean[][] visitedGrid, int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            return 0;
        }
        if (visitedGrid[row][column]) {
            return 0;
        }
        if (grid[row][column] != 1) {
            return 0;
        }
        visitedGrid[row][column] = true;
        int ans = 1;
        ans = ans + dfs(grid, visitedGrid, row - 1, column);
        ans = ans + dfs(grid, visitedGrid, row + 1, column);
        ans = ans + dfs(grid, visitedGrid, row, column - 1);
        ans = ans + dfs(grid, visitedGrid, row, column + 1);
        return ans;
    }
}
