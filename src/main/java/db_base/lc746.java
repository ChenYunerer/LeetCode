package db_base;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc746 {


    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 0; i <= cost.length; i++) {
            if (i == 0 || i == 1) {
                dp[i] = 0;
            } else {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
        }
        return dp[cost.length];
    }

}
