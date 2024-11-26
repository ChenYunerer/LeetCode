package db_base;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

}
