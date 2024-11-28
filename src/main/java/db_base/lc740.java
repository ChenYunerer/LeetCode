package db_base;

/**
 * 740. 删除并获得点数
 * https://leetcode.cn/problems/delete-and-earn/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class lc740 {

    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] sums = new int[max + 1];
        for (int num : nums) {
            sums[num] += num;
        }
        return rob(sums);
    }

    private int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
