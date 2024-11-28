package db_base;

/**
 * 198. 打家劫舍
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc198 {

    /**
     * dp的值：偷到当前位置能偷到的金额
     */
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

    /**
     * dp的值：偷到当前位置能偷到的最大金额
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

}
