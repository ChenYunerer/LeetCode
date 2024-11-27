package db_base;


/**
 * 64. 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc64 {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < columns; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (row == 0 || column == 0) {
                    continue;
                }
                dp[row][column] = Math.min(dp[row - 1][column], dp[row][column - 1]) + grid[row][column];
            }
        }
        return dp[rows - 1][columns - 1];
    }

}
