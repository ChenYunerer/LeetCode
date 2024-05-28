package basicalgorithm.graph.lc200;

/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/description/
 */
public class Solutoin {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visitedGrid = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1' && !visitedGrid[row][column]) {
                    ans++;
                    dfs(grid, visitedGrid, row, column);
                }
            }
        }
        return ans;
    }


    private void dfs(char[][] grid, boolean[][] visitedGrid, int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            return;
        }
        if (visitedGrid[row][column]) {
            return;
        }
        if (grid[row][column] == '0') {
            return;
        }
        visitedGrid[row][column] = true;
        dfs(grid, visitedGrid, row - 1, column);
        dfs(grid, visitedGrid, row + 1, column);
        dfs(grid, visitedGrid, row, column - 1);
        dfs(grid, visitedGrid, row, column + 1);
    }
}
