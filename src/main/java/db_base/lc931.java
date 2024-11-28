package db_base;

/**
 * 931. 下降路径最小和
 * https://leetcode.cn/problems/minimum-falling-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc931 {

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] dp = new int[columns];
        System.arraycopy(matrix[0], 0, dp, 0, columns);
        for (int row = 1; row < rows; row++) {
            int[] tempDp = new int[columns];
            for (int column = 0; column < columns; column++) {
                int a = column - 1 >= 0 ? dp[column - 1] : Integer.MAX_VALUE;
                int b = column + 1 < columns ? dp[column + 1] : Integer.MAX_VALUE;
                int c = dp[column];
                int min = a;
                min = Math.min(min, b);
                min = Math.min(min, c);
                tempDp[column] = min + matrix[row][column];
            }
            dp = tempDp;
        }
        int min = dp[0];
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}
