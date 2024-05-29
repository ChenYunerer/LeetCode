package leetcode_top_100.graph.lc994;

/**
 * 994. 腐烂的橘子
 * https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int round = 0;
        while (true) {
            boolean[][] visitedGrid = new boolean[rows][columns];
            // 本轮感染的橘子数量
            int infectNumInCurRound = 0;
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (grid[row][column] == 2 && !visitedGrid[row][column]) {
                        infectNumInCurRound += dfs(grid, visitedGrid, row, column);
                    }
                }
            }
            if (infectNumInCurRound == 0) {
                // 如果本轮没有感染任何橘子 就不必继续了
                break;
            } else {
                // 如果本轮感染了任意数量的橘子，说明本次轮次有效，轮次加一，继续下轮
                round++;
            }
        }
        // 轮次结束，判断是否还有没有感染的橘子
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 1) {
                    return -1;
                }
            }
        }
        return round;
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
        if (grid[row][column] == 0) {
            // 空格子 不做处理
            return 0;
        }
        // 进入格子 做处理

        visitedGrid[row][column] = true;

        if (grid[row][column] == 1) {
            // 如果是新鲜橘子就使其腐烂
            grid[row][column] = 2;
            return 1;
        }
        if (grid[row][column] == 2) {
            // 如果是腐烂橘子继续dfs
            int ans = 0;
            ans += dfs(grid, visitedGrid, row - 1, column);
            ans += dfs(grid, visitedGrid, row + 1, column);
            ans += dfs(grid, visitedGrid, row, column - 1);
            ans += dfs(grid, visitedGrid, row, column + 1);
            return ans;
        }
        return 0;
    }
}
