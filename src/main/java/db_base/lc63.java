package db_base;

/**
 * 63. 不同路径 II
 * https://leetcode.cn/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        boolean hasStore = false;
        for (int column = 0; column < columns; column++) {
            hasStore = hasStore || obstacleGrid[0][column] == 1;
            dp[0][column] = hasStore ? 0 : 1;
        }
        hasStore = false;
        for (int row = 0; row < rows; row++) {
            hasStore = hasStore || obstacleGrid[row][0] == 1;
            dp[row][0] = hasStore ? 0 : 1;
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (row == 0 || column == 0) {
                    continue;
                }
                if (obstacleGrid[row][column] == 1) {
                    dp[row][column] = 0;
                } else {
                    dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
                }
            }
        }
        return dp[rows - 1][columns - 1];
    }

}
