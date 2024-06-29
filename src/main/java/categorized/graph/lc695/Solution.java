package categorized.graph.lc695;

/**
 * 695. 岛屿的最大面积
 * https://leetcode.cn/problems/max-area-of-island/description/
 */
public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int ans = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visitedGrid = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 1 && !visitedGrid[row][column]) {
                    int curAns = dfs(grid, visitedGrid, row, column);
                    ans = Math.max(ans, curAns);
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
