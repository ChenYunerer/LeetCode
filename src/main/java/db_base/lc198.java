package db_base;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        int maxRob = Math.max(dp[1], dp[2]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            maxRob = Math.max(dp[i], maxRob);
        }
        return maxRob;
    }

}
