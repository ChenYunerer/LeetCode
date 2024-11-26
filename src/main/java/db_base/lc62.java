package db_base;

/**
 * 62. 不同路径
 * https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (row == 0 || column == 0) {
                    continue;
                }
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
