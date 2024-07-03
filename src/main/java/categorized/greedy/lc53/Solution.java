package categorized.greedy.lc53;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/
 */
public class Solution {

    /**
     * 贪心
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum >= 0) {
                preSum += nums[i];
            } else {
                preSum = nums[i];
            }
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

}
