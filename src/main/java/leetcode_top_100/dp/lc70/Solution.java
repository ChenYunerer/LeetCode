package leetcode_top_100.dp.lc70;

/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {

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

    public int climbStairs1(int n) {
        int[] memo = new int[n];
        return doClimbStairs(n, memo);
    }

    public int doClimbStairs(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = doClimbStairs(n - 1, memo) + doClimbStairs(n - 2, memo);
        return memo[n];
    }

}
